package com.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.Admin;
import com.admin.dao.ChangePasswordDAO;

/**
 * Servlet implementation class changepasswordServ
 */
@WebServlet("/changepasswordServ")
public class changepasswordServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepasswordServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  password=request.getParameter("password");
		String 	newPassword=request.getParameter("newpassword");
		PrintWriter out = response.getWriter();
		//System.out.println("Password..."+password);
		//System.out.println("New Password"+newPassword);
		Admin a=new Admin();
		a.setPassword(password);
		a.setNewPassword(newPassword);
		ChangePasswordDAO changePasswordDAO=new ChangePasswordDAO();
		if(!changePasswordDAO.checkPassword(a)) {
	
				 response.sendRedirect("profile.jsp?status=Unable to change password!");
			}
		else {
			 response.sendRedirect("index.jsp?status=Password Change successfully!");
			  
		}
		
	}

}
