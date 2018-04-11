package collage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;

public class Picture {
	private String topic;
	private boolean setWH = false;
	private int width;
	private int height;
	private int x_pos = 0;
	private int y_pos = 0;
	private String url;
	private BufferedImage img;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	// use image width and height
	public Picture(String url_source) {
		width = 0;
		height = 0;
		
		this.url = url_source;
		try {
			URL image_url = new URL(url);
			img = ImageIO.read(image_url);
			height = img.getHeight();
			width = img.getWidth();
		} catch (IOException e) {
			
		}
	}
	
	// with specified width and height
	public Picture(int w, int h, String url_source) {
		width = 0;
		height = 0;
		
		this.url = url_source;
		try {
			URL image_url = new URL(url);
			img = resize(ImageIO.read(image_url), w, h);
			height = h;
			width = w;
			setWH = true;
		} catch (IOException e) {
			
		}
	}
	
	public Picture(int w, int h) {
		width = w;
		height = h;
		setWH = true;
		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getXPos() {
		return x_pos;
	}
	
	public int getYPos() {
		return y_pos;
	}
	
	public int getPixel(int x, int y) {	
		if ( x >= 0 && x < width
				&& y >= 0 && y < height )
			return img.getRGB(x, y);
		else return 0;
	}
	
	public void setPixel(int x, int y, int rgb) {
		if ( x >= 0 && x < width && y >= 0 && y < height )
			img.setRGB(x, y, rgb);
	}
	
	public BufferedImage getImage() {
		//if ( setWH && width > 0 && height > 0 )
		if ( setWH )
			return resize(img, width, height);
		return img;
	}
	
	public BufferedImage getImage(int newW, int newH) {
		return resize(img, newW, newH);
	}
	
	public BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    img = dimg;
	    width = newW;
	    height = newH;
	    setWH = true;
	    
	    return dimg;
	}
	
	public void setImage(BufferedImage bi) {
		img = bi;
		height = bi.getHeight();
		width = bi.getWidth();
	}
	
	public void rotateImage(int angel) {
		AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angel),width / 2, height / 2);//(radian,arbit_X,arbit_Y)

        AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
        
        // create a bigger image for rotation, so that we won't lose corners
        int big_w = (int)Math.ceil(width * 3);
        int big_h = (int)Math.ceil(height * 3);
        int start_x = (int)Math.ceil(width * 1);
        int start_y = (int)Math.ceil(height * 1);
        BufferedImage img2 = new BufferedImage(big_w, big_h, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < big_w; i++) {
        	for (int j = 0; j < big_h; j++) {
        		if ( i < start_x || i >= (start_x + width) )
        			img2.setRGB(i, j, 0);
        		else {
        			if ( j < start_y || j >= (start_y + height) )
        				img2.setRGB(i, j, 0);
        			else {
        				int pos_x = i - start_x;
        				int pos_y = j - start_y;
        				int rgb = 0;
//        				if ( pos_x >= 0 && pos_x < width &&
//        						pos_y >= 0 && pos_y < height )
        					rgb = img.getRGB(i - start_x, j - start_y);
        				img2.setRGB(i, j, rgb);
        			}
        		}     		
        	}
        }
 
        // rotate img2
        BufferedImage bi=op.filter(img2,null);
        
        // change image to the rotated one
        setImage(bi);

        // adjust x, y pos (due to rotation)
        int a2 = Math.abs(angel);
        double x_var = Math.cos(Math.toRadians(90 - a2));
        if ( angel < 0 )
        	x_var = - x_var;
        double y_var = Math.sin(Math.toRadians(angel));
        // System.out.println(angel + "::" + x_var + " == " + y_var);
        x_pos = (int)Math.ceil(start_x * (1.0 - x_var));
        y_pos = (int)Math.ceil(start_y * (1.0 + y_var));
	}
	
	public void writeImage(String fileName, String fileType) {
		try {
		    // retrieve image
		    BufferedImage bi = getImage();
		    File outputfile = new File(fileName);
		    ImageIO.write(bi, fileType, outputfile);
		} catch (IOException e) {
		   
		}
	}
	
	public void addFrame() {
		for(int i = 0; i < width; i++) {
			this.setPixel(i, 0, 255);
			this.setPixel(i, 1, 255);
			this.setPixel(i, 2, 255);
			this.setPixel(i, height-1, 255);
			this.setPixel(i, height-2, 255);
			this.setPixel(i, height-3, 255);
		}
		for(int j = 0; j < height; j++) {
			this.setPixel(0, j, 255);
			this.setPixel(1, j, 255);
			this.setPixel(2, j, 255);
			this.setPixel(width-1, j, 255);
			this.setPixel(width-2, j, 255);
			this.setPixel(width-3, j, 255);
		}
	}
	
}
