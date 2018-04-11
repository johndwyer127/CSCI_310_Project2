package Test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.mockito.Mockito;

import collage.Collage;
import collage.Picture;
import collage.User.UserClass;
//import googleTesting.List;
import googleTesting.Searching;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import Servlets.BuildCollage;
import collage.User.UserClass;

public class JUnitTest extends Mockito{
	/**
	 * Tests for Collage.java
	 */
	//test for getUrls()
	@Test
	public void testGetCatUrls() {
		Collage collage = new Collage();
		List<String> urls = collage.getUrls("cat");
		assertTrue(urls.size() == 30);
	}

	
	//test for getUrls()
	@Test
	public void testGetHappyDogUrls() {
		Collage collage = new Collage();
		List<String> urls = collage.getUrls("happy dog");
		assertTrue(urls.size() == 30);
	} 
	
	//test for getAngles
	@Test
	// tests getAngles returns 30 angles
	public void testGetAnglesSize() {
		Collage collage = new Collage();
		List<Integer> testAngles = collage.getAngles();
		assertTrue(testAngles.size() == 30);
		

	}
	
	//test for getAngles
	@Test
	// gets getAngles returns random angles between -45 and 45
	public void testGetAnglesRange() {
		Collage collage = new Collage();
		List<Integer> testAngles = collage.getAngles();
		boolean inRange = true;
		for (int i = 0; i < testAngles.size(); i++) {
			if (testAngles.get(i) < -45 || testAngles.get(i) > 45) {
				inRange = false;
			}
		}
		
		assertTrue(inRange);
	}
	
	// test for make30collage
	@Test
	public void testMake30CollageW() {
		Collage collage = new Collage();
		List<String> urls = collage.getUrls("dog");
		List<Integer> testAngles = collage.getAngles();
		Picture testPic = collage.make30Collage(800, 600, urls, testAngles);
		
		assertTrue(testPic.getWidth() == 800);
		
	}
	
	// test for make30collage
	@Test
	public void testMake30CollageH() {
		Collage collage = new Collage();
		List<String> urls = collage.getUrls("dog");
		List<Integer> testAngles = collage.getAngles();
		Picture testPic = collage.make30Collage(800, 600, urls, testAngles);
		
		assertTrue(testPic.getHeight() == 600);
		
	}

	/**
	 * Tests for Picture.java
	 */
	@Test
	//test setTopic() and getTopic() in Picture class
	public void testSetTopicAndGetTopic() {
		Picture p = new Picture(100, 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		p.setTopic("god");
		
		assertTrue(p.getTopic().equals("god"));
	}
	
	@Test
	//Test getHeight() and getWidth() in Picture class
	public void testGetHeightAndGetWidth() {
		Picture p = new Picture(100,100);
		assertTrue(p.getHeight() == 100);
		assertTrue(p.getWidth() == 100);
	}
	
	@Test
	//Test constructor that takes 2 ints
	public void testConstructor() {
		Picture p = new Picture(100,100);
		assertTrue(p.getImage().getWidth() == 100);
		assertTrue(p.getImage().getHeight() == 100);
	}
	
	@Test
	//Test getPixel()
	public void testSetPixel() {
		Picture p = new Picture(100, 100);
		p.setPixel(50, 50, 25);
		assertTrue(p.getPixel(50, 50) == 25);
		p.setPixel(-1, 50, 25);
		p.setPixel(50, -1, 25);
		p.setPixel(1, 200, 25);
		p.setPixel(200, 1, 25);
	}
	
	@Test
	//Test setPixel()
	public void testGetPixel()
	{
		Picture p = new Picture(100, 100);
		p.setPixel(50, 50, 25);
		assertTrue(p.getPixel(50, 50) == 25);
		p.getPixel(-1, 1);
		p.getPixel(1, -1);
		p.getPixel(200, 1);
		p.getPixel(1, 200);
	}
	
	@Test
	//Test getImage() no resize
	public void testGetImageNotResized()
	{
		try {
			URL image_url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
			BufferedImage img = ImageIO.read(image_url);
			int height = img.getHeight();
			int width = img.getWidth();
		
			Picture p1 = new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
			assertTrue(p1.getImage().getHeight() == height);
			assertTrue(p1.getImage().getWidth() == width);
		} catch (IOException e) {
			
		}
	}

	@Test
	//Test getImage() resized
	public void testGetImageResized()
	{
		Picture p1 = new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		assertTrue(p1.getImage(50, 50).getHeight() == 50);
	}
	
	@Test
	//Test setImage()
	public void testSetImage() {
		try {
			URL image_url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
			BufferedImage img = ImageIO.read(image_url);
			int height = img.getHeight();
			int width = img.getWidth();
		
			Picture p1 = new Picture(1,1);
			p1.setImage(img);
			assertTrue(p1.getImage().getHeight() == height);
			assertTrue(p1.getImage().getWidth() == width);
		} catch (IOException e) {
			
		}
	}
	
	@Test
	//Test rotate()
	public void testRotatePositiveAngel() {
		Picture p = new Picture(100, 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		int xPos = p.getXPos();
		int yPos = p.getYPos();
		p.rotateImage(20);
		assertTrue(xPos != p.getXPos());
		assertTrue(yPos != p.getYPos());
	}
	
	@Test
	//Test rotate()
	public void testRotateNegativeAngel() {
		Picture p = new Picture(100, 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		int xPos = p.getXPos();
		int yPos = p.getYPos();
		p.rotateImage(-20);
		assertTrue(xPos != p.getXPos());
		assertTrue(yPos != p.getYPos());
	}
	
	@Test
	//Test addFrame()
	public void testAddFrame() {
		Picture p = new Picture(100, 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		int xPos = p.getXPos();
		int yPos = p.getYPos();
		int height = p.getHeight();
		int width = p.getWidth();
		p.addFrame();
		assertTrue(xPos == p.getXPos());
		assertTrue(yPos == p.getYPos());
		assertTrue(height == p.getHeight());
		assertTrue(width == p.getWidth());
	}
	
	@Test
	//Test writeImage()
	public void testWriteImage() {
		Picture p = new Picture(100, 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg/220px-Sabaoth_icon_%28Russia%2C_19_c.%29_2.jpeg");
		p.writeImage("test_image", "png");
		File shouldExist = new File("test_image");
	    assertTrue(shouldExist.exists());
	}
	
	/**
	 * Tests for User.java
	 */
	@Test
	public void testPrevCollagesAfterSearches() {
		Picture newSearch = new Picture(2,2);
		UserClass.setCurrentCollage(newSearch);
		UserClass.numPreviousSearches++;
		assertTrue(UserClass.getNumPreviousSearches() == 0);
		assertTrue(UserClass.getCollages().size() == 0);
		Picture newSearch2 = new Picture(2,2);
		UserClass.addPreviousCollage();
		UserClass.numPreviousSearches++;
		assertTrue(UserClass.getNumPreviousSearches() == 1);
		UserClass.setCurrentCollage(newSearch2);
		assertTrue(UserClass.getCollages().size() == 1);
		assertTrue(UserClass.currentCollage == newSearch2);
		
	}
	
	/**
	 * Tests for Searching.java
	 */
	@Test
	// test for searchQuery() in Searching class
	public void testSearchQueryDog() {
		Searching searchingTest = new Searching();
		try {
			List<String> urls = searchingTest.searchQuery("dog");
			assertTrue(urls.size() == 30);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	// test for searchQuery() in Searching class
	public void testSearchQueryTree() {
		Searching searchingTest = new Searching();
		try {
			List<String> urls = searchingTest.searchQuery("tree");
			assertTrue(urls.size() == 30);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	// test for searchQuery() in Searching class
	public void testSearchQueryHappyDog() {
		Searching searchingTest = new Searching();
		try {
			List<String> urls = searchingTest.searchQuery("happy dog");
			assertTrue(urls.size() == 30);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	// test for searchQuery() in Searching class
	public void testSearchQueryInsufficient() {
		Searching searchingTest = new Searching();
		boolean isCatched = false;
		try {
			List<String> urls = searchingTest.searchQuery("reuiwdjweioopajwiladnwa");
			//assertTrue(urls.size() == 30);
		} catch (IOException e) {
			//e.printStackTrace();
			isCatched = true;
		}
		assertTrue(isCatched);
	}
	
	@Test
	public void testBuildCollage() throws Exception {
		MockitoAnnotations.initMocks(this);  
		 HttpServletRequest request = mock(HttpServletRequest.class);       
         HttpServletResponse response = mock(HttpServletResponse.class);
	     HttpSession session = mock(HttpSession.class);
	     RequestDispatcher rd = mock(RequestDispatcher.class);
	     
	     when(request.getParameter("topic")).thenReturn("dog"); 
	     when(request.getSession()).thenReturn(session);
	     when(request.getSession().getAttribute("topic")).thenReturn("dog");
	     when(request.getRequestDispatcher("/CollageDisplay.jsp")).thenReturn(rd);
	     UserClass.numPreviousSearches++;
	
	     
	     new BuildCollage().service(request, response);

	     
	     
	    


	}
	
}
