package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPetHelper dao = new ListPetHelper();
		String act = request.getParameter("doThisToPet");

		// after all changes, we should redirect to the viewAllpets servlet
		// The only time we don't is if they select to add a new pet or edit
		String path = "/viewAllPetsServlet";

		if (act.equals("delete")) {
			try {
				String name = request.getParameter("name");
				ListPet petToDelete = dao.searchForPetByName(name);
				dao.deletePet(petToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an pet");
			}

		} else if (act.equals("edit")) {
			try {
				String name = request.getParameter("name");
				List<ListPet> petToEdit = dao.searchForPetByName(name);
				request.setAttribute("petToEdit", petToEdit);
				path = "/edit-pet.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a pet");
			}

		} else if (act.equals("add")) {
			path = "/index.html";

		}

		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}