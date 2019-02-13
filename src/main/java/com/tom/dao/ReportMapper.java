package com.tom.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ReportMapper {
	
	@Select("select a.maintainid,a.realname,ifnull(b.works,0) works,ifnull(b.charge,0) charge \r\n"+
	        "from maintainuser a left join \r\n" + 
			"(select a.maintainid,a.realname,count(b.orderid) works,sum(b.charge) charge \r\n"+
			" from maintainuser a,maintainorder b \r\n" + 
			"where a.maintainid=b.maintainid and b.isdelete=0 and a.isdelete=0\r\n" + 
			"group by a.maintainid,a.realname) b on a.maintainid = b.maintainid\r\n" + 
			" where a.isdelete = 0 " +
			"order by b.works desc")
	public List<Map<String, Object>> reportWorks();
	@Select("select a.maintainid,a.realname,ifnull(b.works,0) works,ifnull(b.charge,0) charge \r\n"+
	        " from maintainuser a left join \r\n" + 
			"(select a.maintainid,a.realname,count(b.orderid) works,sum(b.charge) charge \r\n"+
	        " from maintainuser a,maintainorder b \r\n" + 
			"where a.maintainid=b.maintainid and b.isdelete=0 and a.isdelete=0\r\n" + 
			" and b.createtime >= #{date}\r\n" + 
			"group by a.maintainid,a.realname) b on a.maintainid = b.maintainid\r\n" + 
			" where a.isdelete = 0 " +
			"order by b.works desc, a.maintainid")
	public List<Map<String, Object>> reportWorksByCreatetime(Date date);
	
	@Select("select a.maintainid,a.realname,count(b.commentid) count, \r\n" + 
			"ifnull(sum(b.stars)/count(b.commentid),0) averagestars\r\n" + 
			"from maintainuser a\r\n" + 
			"left join comments b\r\n" + 
			"on a.maintainid = b.relationid and a.isdelete=0 and b.isdelete=0 \r\n" + 
			" where a.isdelete = 0 " +
			"GROUP BY a.maintainid,a.realname\r\n" + 
			"order by averagestars desc,count desc,a.maintainid")
	public List<Map<String, Object>> reportStars();
	
	@Select("select a.maintainid,a.realname,count(b.commentid) count, \r\n" + 
			"ifnull(sum(b.stars)/count(b.commentid),0) averagestars\r\n" + 
			"from maintainuser a\r\n" + 
			"left join comments b\r\n" + 
			"on a.maintainid = b.relationid and a.isdelete=0 and b.isdelete=0\r\n" + 
			"and b.createtime >= #{date}\r\n" + 
			" where a.isdelete = 0 " +
			"GROUP BY a.maintainid,a.realname\r\n" + 
			"order by averagestars desc,count desc,a.maintainid")
	public List<Map<String, Object>> reportStarsByCreatetime(Date date);
}
