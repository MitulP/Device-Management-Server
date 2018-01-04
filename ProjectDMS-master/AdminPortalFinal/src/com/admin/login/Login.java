package com.admin.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.bean.Admin;
import com.admin.dao.AdminLogin;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		Admin a=new Admin();
		a.setUname(uname);
		a.setPassword(pass);
		AdminLogin al=new AdminLogin();
		if(al.checkLogin(a)) {
				
			HttpSession session=request.getSession(true);
			session.setAttribute("uname", uname);
			session.setAttribute("pass", pass);
            response.sendRedirect("home.jsp");
			
		}else {
			
			response.sendRedirect("index.jsp?status=login failed");
		}
		
		doGet(request, response);
	}

}
