package com.tom.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectoryBase;

/**
 * 处理图片旋转帮助类
 * @author tom
 * @since 2019-01-01 23:02:43
 */
public class RotateImage {
	
    public static BufferedImage Rotate(Image src, int angel) {  
        int src_width = src.getWidth(null);  
        int src_height = src.getHeight(null);  
        // calculate the new image size  
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(  
                src_width, src_height)), angel);  

        BufferedImage res = null;  
        res = new BufferedImage(rect_des.width, rect_des.height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g2 = res.createGraphics();  
        // transform  
        g2.translate((rect_des.width - src_width) / 2,  
                (rect_des.height - src_height) / 2);  
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);  

        g2.drawImage(src, null, null);  


        return res;  
    }  



    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {  
        // if angel is greater than 90 degree, we need to do some conversion  
        if (angel >= 90) {  
            if(angel / 90 % 2 == 1){  
                int temp = src.height;  
                src.height = src.width;  
                src.width = temp;  
            }  
            angel = angel % 90;  
        }  

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;  
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;  
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;  
        double angel_dalta_width = Math.atan((double) src.height / src.width);  
        double angel_dalta_height = Math.atan((double) src.width / src.height);  

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_width));  
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_height));  
        int des_width = src.width + len_dalta_width * 2;  
        int des_height = src.height + len_dalta_height * 2;  


        return new Rectangle(new Dimension(des_width, des_height));  
    }

    public static void fixPicture(String fileUrl) {
    	/**
    	 * 旋转图片
         */
    	try {
	        Metadata metadata = JpegMetadataReader.readMetadata(new File(fileUrl));
	        Directory directory = metadata.getFirstDirectoryOfType(ExifDirectoryBase.class);
	        int orientation = 0;
	        if (directory != null && directory.containsTag(ExifDirectoryBase.TAG_ORIENTATION)) { // Exif信息中有保存方向,把信息复制到缩略图
	            orientation = directory.getInt(ExifDirectoryBase.TAG_ORIENTATION); // 原图片的方向信息
	            System.err.println("orientation:" + orientation);
	        }
	
	        if (orientation == 1) {
	            System.out.println("rotate 90");
	            BufferedImage src = ImageIO.read(new File(fileUrl));
	            BufferedImage des = RotateImage.Rotate(src, 0);
	            ImageIO.write(des, "jpg", new File(fileUrl));
	        } else if (6 == orientation) {
	            // 6旋转90
	            System.out.println("rotate 90");
	            BufferedImage src = ImageIO.read(new File(fileUrl));
	            BufferedImage des = RotateImage.Rotate(src, 90);
	            ImageIO.write(des, "jpg", new File(fileUrl));
	        } else if (3 == orientation) {
	            // 3旋转180
	            System.out.println("rotate 180");
	            BufferedImage src = ImageIO.read(new File(fileUrl));
	            BufferedImage des = RotateImage.Rotate(src, 180);
	            ImageIO.write(des, "jpg", new File(fileUrl));
	        } else if (8 == orientation) {
	            // 8旋转90
	            System.out.println("rotate 90");
	            BufferedImage src = ImageIO.read(new File(fileUrl));
	            BufferedImage des = RotateImage.Rotate(src, 270);
	            ImageIO.write(des, "jpg", new File(fileUrl));
	        }
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
