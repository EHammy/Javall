package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalculateNumbers;



/**
 * Servlet implementation class getNumbersServlet
 */
@WebServlet("/getNumbersServlet")
public class getNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNumbersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String firstNumber = request.getParameter("firstNumber");
				String secondNumber = request.getParameter("secondNumber");
				
				//CalculateNumbers firstNumber1 = new CalculateNumbers(Integer.parseInt(firstNumber1));
				//CalculateNumbers secondNumber1 = new CalculateNumbers(Integer.parseInt(secondNumber1));
				
				//request.setAttribute("userCoinPouch", secondNumber1);
				
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				
				PrintWriter writer = response.getWriter();
				writer.println("Number 1: " + firstNumber.toString());
				writer.println("Number 2: " + secondNumber.toString());
				writer.close();
		
	}

}
