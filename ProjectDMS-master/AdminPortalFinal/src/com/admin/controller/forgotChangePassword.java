package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.otp.ChangePassword;

/**
 * Servlet implementation class forgotChangePassword
 */
@WebServlet("/forgotChangePassword")
public class forgotChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password=request.getParameter("newpwd");
		String cpassword=request.getParameter("cpwd");
		System.out.println(password+"\t"+cpassword);
		
		boolean b=ChangePassword.changePassword(password, cpassword);
		
		if(b)
			response.sendRedirect("index.jsp?status=password changed successfully");
		else
			response.sendRedirect("index.jsp?status=password changed failed");
			
		
		
		
		
		
	}

}
