package com.tom.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpUtil {

	private static Logger log=LoggerFactory.getLogger(HttpUtil.class);
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	public static void main(String[] args){
		try {
			String strUrl="http://172.16.152.105:8080/Every360/webchatHttpService?command=invite&chat_token=fd04580ogfndv90725ygv9f97445ht9-902y4thof93249ghfspdadf089ugea&jsonstr=%5B%7B%22sessionStartTime%22%3A%22%22%2C%22platform%22%3A%223%22%2C%22csEndTime%22%3A%22%22%2C%22fontColor%22%3A%22%22%2C%22fontName%22%3A%22%22%2C%22key_user_name%22%3A%22%E9%BB%84%E5%B2%A9%E8%BF%99%E4%B8%AA%E8%83%96%E5%AD%90%22%2C%22userIP%22%3A%22%22%2C%22skillGroup%22%3Anull%2C%22fontStyle%22%3A%22%22%2C%22userBrand%22%3A%22%22%2C%22csTimeLength%22%3A%22%22%2C%22csStartTime%22%3A%22%22%2C%22csNumber%22%3A%22%22%2C%22p4Title%22%3A%22%22%2C%22publicAccountId%22%3A%22gh_ab3d35b11129%22%2C%22latestQA%22%3A%22%22%2C%22csName%22%3A%22%22%2C%22user_head_pic%22%3A%22http%3A%2F%2F172.16.152.105%2FWeiChat%2Flocalfile%2F1514471916628_17944680.jpg%22%2C%22p4Url%22%3A%22%22%2C%22sessionId%22%3A%22ESOONWX5df369f4-351b-4e5f-b2ae-631c420ff050%22%2C%22userId%22%3A%22onJ7qvqa0kufYJTSJDVjzrRnjM7A%22%2C%22userLocation%22%3A%22%22%7D%5D";
			//String result = HttpUtil.net("", new HashMap<>(), "GET", true);
			//System.err.println("result:"+result);
			
			HttpURLConnection conn = null;
			BufferedReader reader = null;
			String rs = null;
			try {
				StringBuffer sb = new StringBuffer();
				//if (method == null || method.equals("GET")) {
				//	strUrl = strUrl + "?" + HttpUtil.urlencode(params);
				//}
				System.err.println(strUrl);
				URL url = new URL(strUrl);
				conn = (HttpURLConnection) url.openConnection();
				//if (method == null || method.equals("GET")) {
					conn.setRequestMethod("GET");
				//} else {
				//	conn.setRequestMethod("POST");
				//	conn.setDoOutput(true);
				//}
				conn.setRequestProperty("User-agent", userAgent);
				conn.setUseCaches(false);
				conn.setConnectTimeout(DEF_CONN_TIMEOUT);
				conn.setReadTimeout(DEF_READ_TIMEOUT);
				conn.setInstanceFollowRedirects(false);
				conn.connect();
				/*if (params != null && method.equals("POST")) {
					try {
						DataOutputStream out = new DataOutputStream(conn.getOutputStream());
						out.writeBytes(isJsonStr?JSONObject.toJSONString(params):HttpUtil.urlencode(params));
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}*/
				InputStream is = conn.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sb.append(strRead);
				}
				rs = sb.toString();
			} catch (IOException e) {
				//System.out.println("－－－－－－－HTTP未连接上－－－－－－－－－－－－");
				log.warn("－－－－－－－HTTP未连接上－－－－－－－－－－－－");
				e.printStackTrace();
			} finally {
				if (reader != null) {
					reader.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			}
			System.out.println("result:"+rs);
			//return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String postByHttpClient(String urlStr, Map<String, String> params, Map<String, String> headers) {
		log.info("url-- " + urlStr + "?" + params);
		HttpClient client = new DefaultHttpClient();
		StringBuffer buffer = new StringBuffer();
		String rs = "";

		HttpPost httppost = new HttpPost(urlStr);

		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httppost.setHeader(entry.getKey(), entry.getValue());
			}
		}

		try {
			StringEntity stringEntity = new StringEntity(buildParams(params), "utf-8");
			httppost.setEntity(stringEntity);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		HttpResponse response;
		InputStream instream = null;
		BufferedReader in = null;
		try {

			response = client.execute(httppost);

			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
				instream = response.getEntity().getContent();
				;
				in = new BufferedReader(new InputStreamReader(instream, "utf-8"));
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				rs = buffer.toString();
				
				//System.out.print(rs);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			log.error("HttpClient post error! ", e);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HttpClient post error! ", e);
		} finally {
			if (instream != null) {
				try {
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httppost != null) {
				try {
					httppost.releaseConnection();
				} catch (Exception e) {
					log.error("-------> Release HTTP connection exception:", e);
				}
			}
			if (client != null) {
				try {
					client.getConnectionManager().closeIdleConnections(0, TimeUnit.SECONDS);
				} catch (Exception e) {
					log.error("-------> Close HTTP connection exception:", e);
				}
				client = null;
			}

			client = null;
			buffer = null;
			httppost = null;
			response = null;
			instream = null;
			in = null;
		}
		return rs;
	}

	public static String buildParams(Map<String, ? extends Object> params) throws UnsupportedEncodingException {
		if (params == null || params.isEmpty()) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
			if (entry.getKey() != null && entry.getValue() != null)
				builder.append(entry.getKey().trim()).append("=")
						.append(URLEncoder.encode(entry.getValue().toString(), DEF_CHATSET)).append("&");
		}

		if (builder.charAt(builder.length() - 1) == '&') {
			builder.deleteCharAt(builder.length() - 1);
		}

		return builder.toString();
	}

	public static String postByHttpClient(String urlStr, String params) {
		log.info("url-- " + urlStr + "?" + params);
		HttpClient client = new DefaultHttpClient();
		StringBuffer buffer = new StringBuffer();
		String rs = "";

		HttpPost httppost = new HttpPost(urlStr);
		// httppost.setHeader("Content-type", "text/xml");
		// 另外一种设置参数方式
		try {
			StringEntity stringEntity = new StringEntity(params, "utf-8");
			httppost.setEntity(stringEntity);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		HttpResponse response;
		InputStream instream = null;
		BufferedReader in = null;
		try {
			// 设置编码
			// httppost.setEntity(new
			// UrlEncodedFormEntity(listParams,HTTP.UTF_8));
			response = client.execute(httppost);
			// 发送Post,并返回一个HttpResponse对象
			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
				instream = response.getEntity().getContent();
				;
				in = new BufferedReader(new InputStreamReader(instream, "utf-8"));
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				rs = buffer.toString();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			log.error("HttpClient post error! ", e);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HttpClient post error! ", e);
		} finally {
			if (instream != null) {
				try {
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httppost != null) {
				try {
					httppost.releaseConnection();
				} catch (Exception e) {
					log.error("-------> Release HTTP connection exception:", e);
				}
			}
			if (client != null) {
				try {
					client.getConnectionManager().closeIdleConnections(0, TimeUnit.SECONDS);
				} catch (Exception e) {
					log.error("-------> Close HTTP connection exception:", e);
				}
				client = null;
			}

			client = null;
			buffer = null;
			httppost = null;
			response = null;
			instream = null;
			in = null;
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map<String, String> params, String method, boolean isJsonStr) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + HttpUtil.urlencode(params);
			}
			System.err.println(strUrl);
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(isJsonStr?JSONObject.toJSONString(params):HttpUtil.urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			//System.out.println("－－－－－－－HTTP未连接上－－－－－－－－－－－－");
			log.warn("－－－－－－－HTTP未连接上－－－－－－－－－－－－");
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	public static final String filterStr2(String value) {

		if (value == null) {
			return "";
		}
		value = value.replace("\\n", "\n");
		value = value.replace("\\r\\n", "\n");
		value = value.replace("\r\n", "\n");
		// value = value.replaceAll(";", "");
		// value = value.replaceAll("@", "");
		// value = value.replaceAll("'", "");
		value = value.replace("&quot;", "\"");
		// value = value.replaceAll("\\'", "");
		value = value.replace("\\", "\\\\");
		value = value.replace("&lt;", "<");
		value = value.replace("&gt;", ">");
		value = value.replace("&amp;", "&");
		value = value.replace("@/@", "%");
		value = value.replace("＋", "+");

		value = value.replace("<br>", "\n");
		value = value.replace("<br >", "\n");
		value = value.replace("<br />", "\n");
		value = value.replace("<br/>", "\n");
		value = value.replace("</br>", "\n");
		value = value.replace("</BR>", "\n");
		value = value.replace("</Br>", "\n");
		value = value.replace("<BR>", "\n");
		value = value.replace("<Br>", "\n");
		return value;
	}
	
	/**
	 * 数据格式为json的http请求方法
	 * @param sendurl 链接地址
	 * @param data json格式字符串
	 * @author tom
	 * @since 2017-11-10 10:53:32
	 * @return
	 */
	public static String sendInfo(String sendurl, String data) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(sendurl);
        StringEntity myEntity = new StringEntity(data,
                ContentType.APPLICATION_JSON);// 构造请求数据
        post.setEntity(myEntity);// 设置请求体
        String responseContent = null; // 响应内容
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null)
                    response.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (client != null)
                        client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseContent;
    }
	
	public static String getByHttpClient(String urlStr, Map<String, String> headers) {
		System.out.println(urlStr);
		DefaultHttpClient client = new DefaultHttpClient();
		//if(PropKit.use("application.properties").get("isSetHttpProxy")==null?false:(PropKit.use("application.properties").getInt("isSetHttpProxy")==1)){
		//	HttpHost proxy = new HttpHost(PropKit.use("application.properties").get("proxyHost"), PropKit.use("application.properties").getInt("proxyPort"));
		//	client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		//}
		HttpGet httpGet = new HttpGet(urlStr);
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpGet.setHeader(entry.getKey(), entry.getValue());
			}
		}
		try {
			HttpResponse response = client.execute(httpGet);
			  final StatusLine statusLine = response.getStatusLine();
			    final HttpEntity entity = response.getEntity();
			    if (statusLine.getStatusCode() >= 300) {
			      EntityUtils.consume(entity);
			      throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			    }
			    return entity == null ? null : EntityUtils.toString(entity, Consts.UTF_8);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
