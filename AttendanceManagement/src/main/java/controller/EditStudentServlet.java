package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListStudent;

/**
 * Servlet implementation class editStudentServlet
 */
@WebServlet("/editStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListStudentHelper dao = new ListStudentHelper();
		
		String student = request.getParameter("student");
		String attendance = request.getParameter("attendance");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		ListStudent StudentToUpdate = dao.searchForStudentById(tempId);
		StudentToUpdate.setStudent(student);
		StudentToUpdate.setAttendance(attendance);
				
		dao.updateStudent(StudentToUpdate);

		getServletContext().getRequestDispatcher("/viewAllStudentsServlet").forward(request, response);


	}

}

