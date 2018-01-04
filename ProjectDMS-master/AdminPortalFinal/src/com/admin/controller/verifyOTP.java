package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.bean.AdminOTP;
import com.admin.dao.AdminOTPDAO;

/**
 * Servlet implementation class verifyOTP
 */
@WebServlet("/verifyOTP")
public class verifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyOTP() {
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
		// TODO Auto-generated method stub
		AdminOTPDAO a=new AdminOTPDAO();
		int otp=Integer.parseInt(request.getParameter("otp"));
		String uuid=a.verifyUserOTP(otp);
		if(uuid!=null) {
		HttpSession session=request.getSession();
		session.setAttribute("key",uuid);
		response.sendRedirect("change_password.jsp");	
			
		}else{
			
			response.sendRedirect("otp.jsp?status=not valid otp");
		}
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
