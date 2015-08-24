/*
 * This servlet accepts an person id, searches and return person detail
 */
package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPersonDetail
 */
@WebServlet("/PersonDetail")
public class ServletPersonDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get input from client
		System.out.println("dopost");
		String idStr = request.getParameter("id");
		
		
		//validate input
		if(!Validator.validateInt(idStr))
		{
			//send error if invalid integer
			response.sendError(400, "Invalid input");
		}
		else
		{
			//format input
			int id = Integer.parseInt(idStr);
			
			//find a person with an id
			DB db = new DB();
			Person person = db.findPersonWithId(id);
			
			//set up return string
			String personData = "";
			
			personData += "<p> ID: ";
			personData += person.getId();
			personData += "</p>";
			
			personData += "<p> Title: ";
			personData += person.getTitle();
			personData += "</p>";
			
			personData += "<p> Name: ";
			personData += person.getFirstName() + " " + person.getLastName() ;
			personData += "</p>";
			
			personData += "<p> Company: ";
			personData += person.getCompanyName();
			personData += "</p>";
			
			personData += "<p> Position: ";
			personData += person.getPosition();
			personData += "</p>";
			
			personData += "<p> Address: ";
			personData += person.getStreetAddress() + " " + person.getCity() + " " + person.getStateName() + " " + person.getZipCode();
			personData += "</p>";
			
			personData += "<p> Email: ";
			personData += person.getEmailAddress();
			personData += "</p>";
			
			//set personData and forward it to a jsp page to display data
			request.setAttribute("personData", personData);
			getServletContext().getRequestDispatcher("/PersonDetail.jsp").forward(request, response);
		}
		
	}

}
