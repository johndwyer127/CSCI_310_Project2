package collage;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import collage.Picture;
import googleTesting.Searching;


public final class Collage {
	public List<String> getUrls(String topic) {
		Searching newSearch = new Searching();
		List<String> urls = new ArrayList<String>();
		try {
			urls = newSearch.searchQuery(topic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urls;
	}
	public List<Integer> getAngles() {
		List<Integer> angles = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			Random rand = new Random();
			int input = rand.nextInt(91) - 45;
			angles.add(input);
		}
		return angles;

	}



//	// This code will copy part of one picture to another picture
//	public static Picture makeCollage (Picture pict, Picture pict2, Picture pict3)
//	{
//making sure all the collage
//		int xStart, xEnd;
//		int yStart, yEnd;
//
//		/* xStart = 250;
//		yStart = 150;
//		xEnd = 400;
//		yEnd = 300; */
//
//		// declare variables for the loop
//		int xIndex, xIndex1, xIndex2;
//		int yIndex, yIndex1, yIndex2;
//		int pixel1, pixel2;
//
//		// get width and height of picture
//		int width = pict.getWidth();
//		int height = pict.getHeight();
//
//		// create a bit "empty canvas" for new picture
//		int width2 = width + pict2.getWidth() + pict3.getWidth();
//		int height2 = height + pict2.getHeight();
//		Picture pictNew = new Picture (width2, height2);
//
//		// create a for loop to access/manipulate each pixel
//		// copy pict to pictNew
//		for ( xIndex = 0 ; xIndex < width ; xIndex = xIndex + 1 ) {
//		    for ( yIndex = 0 ; yIndex < height ; yIndex = yIndex + 1 ) {
//		         // get the pixel from the original picture base on X,Y position
//		         xIndex1 = xIndex;
//		         yIndex1 = yIndex;
//		         pixel1 = pict.getPixel (xIndex1, yIndex1);
//
//		         pictNew.setPixel(xIndex, yIndex, pixel1);
//		        }
//		   }
//
//		   int widthA = pict2.getWidth();
//		   int heightA = pict2.getHeight();
//
//		   // create a for loop to access/manipulate each pixel for the lower image
//		   // i.e., append pict2 to be below pict in pictNew
//		   for ( xIndex = 0 ; xIndex < widthA ; xIndex = xIndex + 1 )
//		   {
//		      for ( yIndex = 0 ; yIndex < heightA ; yIndex = yIndex + 1 )
//		        {
//		         // get the pixel from the original picture base on X,Y position
//		         xIndex1 = xIndex;
//		         yIndex1 = yIndex;
//		         pixel1 = pict2.getPixel (xIndex1, yIndex1);
//
//		         // determine the corresponding pixel in the new picture
//		         xIndex2 = xIndex ;
//		         yIndex2 = yIndex + height;
//		         pictNew.setPixel (xIndex2, yIndex2, pixel1);
//		        }
//		   }
//
//		   int widthB = pict3.getWidth();
//		   int heightB = pict3.getHeight();
//		   // create a for loop to access/manipulate each pixel for the lower image
//		   // i.e., add pict3 to the right
//		   for ( xIndex = 0 ; xIndex < widthB ; xIndex = xIndex + 1 )
//		   {
//		      for ( yIndex = 0 ; yIndex < heightB ; yIndex = yIndex + 1 )
//		        {
//		         // get the pixel from the original picture base on X,Y position
//		         xIndex1 = xIndex;
//		         yIndex1 = yIndex;
//		         pixel1 = pict3.getPixel (xIndex1, yIndex1);
//
//		         // determine the corresponding pixel in the new picture
//		         xIndex2 = xIndex + widthA;
//		         yIndex2 = yIndex + height;
//		         pictNew.setPixel (xIndex2, yIndex2, pixel1);
//		        }
//		   }
//
//		   // create a for loop to access/manipulate each pixel for the lower image
//		   // add pict2 to the right once more
//		   for ( xIndex = 0 ; xIndex < widthA ; xIndex = xIndex + 1 )
//		   {
//		      for ( yIndex = 0 ; yIndex < heightA ; yIndex = yIndex + 1 )
//		        {
//		         // get the pixel from the original picture base on X,Y position
//		         xIndex1 = xIndex;
//		         yIndex1 = yIndex;
//		         pixel1 = pict2.getPixel(xIndex1, yIndex1);
//
//		         // determine the corresponding pixel in the new picture
//		         xIndex2 = xIndex + widthA + widthB;
//		         yIndex2 = yIndex + height;
//		         pictNew.setPixel (xIndex2, yIndex2, pixel1);
//		        }
//		   }
//
//		return pictNew;
//	}


	public static Picture make30Collage (int new_width, int new_height, List<String> nameList, List<Integer> angelList) {
		Picture pictNew = new Picture (new_width, new_height);

		int row = 5;
		int col = 6;

		// decide the width and height of each component picture
		// each is 1/20th of the new picture
		int width = (int)Math.ceil(new_width / 5);
		int height = (int)Math.ceil(new_height / 4);
		// System.out.println("width: " + width + ", height: " + height);

		List<Picture> pictList = new ArrayList<Picture>();
		for (int k = 0; k < nameList.size(); k++) {
			String name = nameList.get(k);
			Picture pict = new Picture(width, height, name);
			pict.addFrame();
			// rotate the picture to angel degree
			int angel = angelList.get(k).intValue();
			if ( angel != 0 )
				pict.rotateImage(angel);

			pictList.add(pict);
		}

		// decide the area each component picture needs to cover
		int cw = (int)Math.ceil(new_width / col);
		int ch = (int)Math.ceil(new_height / row);
		int diffw = (int)Math.ceil((width - cw) / 4);
		int diffh = (int)Math.ceil((height - ch) / 4);

		// System.out.println(cw + "," + ch + "," + diffw + "," + diffh);

		// determine start position of each picture
		List<Integer> x_arr = new ArrayList<Integer>();
		List<Integer> y_arr = new ArrayList<Integer>();

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				int x = cw * i;
				x -= (int)(Math.random() * diffw);
				x_arr.add(x);
				int y = ch * j;
				y -= (int)(Math.random() * diffh);
				y_arr.add(y);
			}
		}

		// shuffle pictures
		int count = 30;
		int[] orderList = new int[count];
		for (int k = 0; k < count; k++) {
			orderList[k] = k;
		}
		for (int i = 0; i < count; i++) {
			int j = (int)(Math.random() * count); // Get a random index out of count
		    int temp = orderList[i]; // Swap
		    orderList[i] = orderList[j];
		    orderList[j] = temp;
		}

		// add each component picture to new picture
		for (int n = 0; n < count; n++) {
			int k = orderList[n];
			System.out.println(k);
			System.out.println(pictList.size());

			int idx = k % pictList.size();
			Picture pict = pictList.get(idx);


			int start_x = x_arr.get(k).intValue();
			int start_y = y_arr.get(k).intValue();
			start_x -= pict.getXPos();
			start_y -= pict.getYPos();

			System.out.println("start " + n + ":" + start_x + ", " + start_y);
			System.out.println(pict.getXPos() + ", " + pict.getYPos());

			for (int i = 0; i < pict.getWidth(); i++) {
				int x = i + start_x;
				for (int j = 0; j < pict.getHeight(); j++) {
					int y = j + start_y;
					int pixel = pict.getPixel(i, j);
					// System.out.println("*** " + i + " " + j + " " + pixel);
					if ( pixel != 0 )
						pictNew.setPixel(x, y, pixel);
				}
			}

		}
		return pictNew;
	}
}
