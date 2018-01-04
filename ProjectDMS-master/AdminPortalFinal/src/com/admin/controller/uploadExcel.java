package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.admin.dao.ImportExcelDAO;

/**
 * Servlet implementation class uploadExcel
 */
@WebServlet("/uploadExcel")
@MultipartConfig(maxFileSize = 999999999)
public class uploadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file=request.getPart("file");
		boolean status=ImportExcelDAO.importFile(file.getInputStream());
	
		if(!status) {
			response.sendRedirect("ErrorFileUpload.jsp");
			
		}else {
			response.sendRedirect("SuccessFileUpload.jsp");
			
		}
	
	}

}
