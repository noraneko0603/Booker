package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.connect.Connect;




/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String sentId = request.getParameter("login-id");
        String sentPw = request.getParameter("password");
        String pass = Connect.select(sentId);
        System.out.println(sentPw + "入力されたパスワード");
        //System.out.println("------------------------"); 
       // System.out.println(pass + "SQLから参照したパスワード");
		if (sentPw.equals(pass) == true) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", true);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("loginErrorMsg", "ログイン情報が不正です。");
            request.setAttribute("errorFlg", true);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(request, response);
    }

}
