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
 * Servlet implementation class edit PetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPetHelper dao = new ListPetHelper();
		
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		String weight = request.getParameter("weight");
		
				
		List<ListPet> petToUpdate = dao.searchForPetByName(name);
		petToUpdate.setName(name);
		petToUpdate.setBreed(breed);
		petToUpdate.setWeight(weight);
				
		dao.updatePet(petToUpdate);

		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);


	}

}
