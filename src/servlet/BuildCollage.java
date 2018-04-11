package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collage.Collage;
import collage.Picture;
import collage.User;
import collage.User.UserClass;

/**
 * Servlet implementation class BuildCollage
 */
@WebServlet("/BuildCollage")
public class BuildCollage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildCollage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topic = request.getParameter("topic");
		System.out.println("topic= " + topic);
		response.setContentType("text/html"); //can do text/json, in servlets usually will be text/html
		Collage newCollage = new Collage();
		List<String> urls = newCollage.getUrls(topic);
//		for (int i=0; i < urls.size(); i++) {
//			System.out.println(urls.get(i));
//		}
		Picture collageImage = Collage.make30Collage(800, 600, urls, newCollage.getAngles());

		UserClass.numPreviousSearches++;
		
		if (UserClass.getNumPreviousSearches() != 0) {
			UserClass.addPreviousCollage(); //add old collage to list of historical collages
		}
		
		UserClass.setCurrentCollage(collageImage); //update current collage to the new search
		collageImage.setTopic(topic);
		UserClass.setCurrentCollage(collageImage); //update current collage to the new search
		List<Picture> history = UserClass.getCollages();
		System.out.println("history size: " + history.size());
		request.getSession().setAttribute("collageImage", collageImage);
		request.getSession().setAttribute("topic", topic);
		request.getSession().setAttribute("history", history);
		//RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/CollageDisplay.jsp");
		RequestDispatcher dispatch = request.getRequestDispatcher("/CollageDisplay.jsp");
		dispatch.forward(request, response);
	}

}
