package com.kjl.utils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {
	/*
	 * swing图形化技术
	 * 
	 */
	
	
	private int width = 100;//宽度
	private int height = 35;//高度
	private Random r = new Random();//随机产生数的对象
	private String[] fontNames = {"宋体","华文楷体","黑体","隶书","微软雅黑","Tahoma","Segoe Print"};//定义一个字体的数组
	private String codes = "0123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";//字符
	private Color bgColor = new Color(255, 255, 255);//颜色
	private String text;
	
	//生成一个颜色
	public Color randomColor(){
		int red = r.nextInt(200); 
		int green = r.nextInt(200); 
		int blue = r.nextInt(200); 
		return new Color(red,green,blue);
	}
	
	//生成随机字体
	public Font randomFont(){
		int index  = r.nextInt(fontNames.length);
		String fontName = fontNames[index];//字体名称
		
		int style = r.nextInt(4);
		int size = r.nextInt(6)+20;
		
		return new Font(fontName, style, size);//1、字体  ;2、样式（0,表示无样式；1,表示粗体；2,斜体；3,表示粗体加斜体）3，大小
		
	}
	
	//生成一个字符
	public char randomChar(){
		int index  = r.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	//画干扰线
	public void drawLine(BufferedImage image){
		
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		int len = r.nextInt(3)+3;
		//生成两个坐标点，4个值
		for(int i=0;i<len;i++){
			int x1 = r.nextInt(width);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(width);
			int y2 = r.nextInt(height);
			
			graph.setColor(randomColor());//设置笔的颜色
			graph.setStroke(new BasicStroke(1.2f));//设置线的粗细
			
			graph.drawLine(x1, y1, x2, y2);//画线
		}
	}
	
	//创建BufferedImage对象    矩型
	public BufferedImage createImage(){
		//创建图片缓冲区
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		//设置笔的颜色
		graph.setColor(bgColor);
		graph.fillRect(0, 0, width, height);
		return image;
	}
	//图片上画4个字符
	public BufferedImage getImage(){
		BufferedImage image = createImage();//得到矩型
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {//向图片上画4个字符
			String str = randomChar()+"";
			sb.append(str);
			graph.setFont(randomFont());//设置画笔的字体
			graph.setColor(randomColor());//设置画笔的颜色
			float x = i * 1.0f * width / 4;//设置当前字符的X位置
			graph.drawString(str, x, height-5);
		}
		
		text = sb.toString();//4个字符
		drawLine(image);
		return image;
	}
	
	
	//得到字符串
	public String getText(){
		return text;
	}
	
	
	//保存图片到指定位置
	public void output(BufferedImage image,OutputStream out){
		try {
			ImageIO.write(image, "JPEG", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		VerifyCode verify = new VerifyCode();
		BufferedImage image = verify.getImage();
		OutputStream out = new FileOutputStream("E:\\XXX.jpg");
		verify.output(image, out);
		
		System.out.println(verify.getText());
		
		
	}
	
	

}
