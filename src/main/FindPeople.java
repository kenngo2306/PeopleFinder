/*
 * This servlet is used to accept a string from user and search for the last name in the database
 */
package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindPeople
 */
@WebServlet("/FindPeople")
public class FindPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get input parameter
		String queryStr = request.getParameter("query");
		
		//TODO validate inputs
		//do nothing yet
		
		//uppercase the query string
		String finalQuery = queryStr.toUpperCase();
		
		//search for a list of people in the database
		DB db = new DB();
		ArrayList<Person> people = db.findPeople(finalQuery);
		
		//loop through the resultset and create table data
		String tableData = "";
		for(Person person:people)
		{
			tableData += "<tr>";
			tableData += "<td>";
			tableData += person.getId();
			tableData += "</td>";
			tableData += "<td>";
			tableData += person.getFirstName();
			tableData += "</td>";
			tableData += "<td>";
			tableData += person.getLastName();
			tableData += "</td>";
			tableData += "<td>";
			tableData += "<a href=\"PersonDetail?id=" + person.getId() + "\">View Detail </a>";
			tableData += "</td>";
			tableData += "</tr>";
		}
		
		//set table data as a attribute and call peoplelist.jsp to display the table to user
		request.setAttribute("tableData", tableData);
		getServletContext().getRequestDispatcher("/PeopleList.jsp").forward(request, response);
	}

}
