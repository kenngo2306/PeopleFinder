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
		String queryStr = request.getParameter("query");
		String finalQuery = queryStr.toUpperCase();
		DB db = new DB();
		ArrayList<Person> people = db.findPeople(finalQuery);
		
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
		request.setAttribute("tableData", tableData);
		getServletContext().getRequestDispatcher("/PeopleList.jsp").forward(request, response);
	}

}
