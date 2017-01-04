package com.acit.csam.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acit.csam.dao.CSAManagerDao;
import com.acit.csam.exception.CSAMException;

@WebServlet("/LoginController")  
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String ADD_REQUEST = "/viewFormsDetails.jsp";
    private static String LOGIN_PAGE = "/login.jsp";
    private CSAManagerDao dao;
  
    public LoginController() {
        super();
        dao = new CSAManagerDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String forward="";
        try{
        	
	        boolean status=dao.validateUser(userName, request.getParameter("password"));
	        System.out.println("userid"+userName);  
	        System.out.println("status of user "+status);
	        HttpSession session = request.getSession();
	        //session.setAttribute("userName", "Guest");
	        session.setMaxInactiveInterval(600);
	        
	    	session.setAttribute("userId", userName);
	        if(status){
	        	forward=ADD_REQUEST;
	        	session.setAttribute("userName", userName);
	        	/*SkillInfo skillInfo=new SkillInfo();
	        	skillInfo=dao.getUserDetails(userName);
	        	 
	        	request.setAttribute("userDetails", skillInfo);
	
	        	if(skillInfo.getEmployeeRole().equalsIgnoreCase("user")){
	        		if(skillInfo.getCertUploadFlag()!=null && skillInfo.getCertUploadFlag().equalsIgnoreCase("YES")){
	        			//request.setAttribute("uploadFlag", "YES");
	        			//request.setAttribute("skillList", dao.getFormDataByEntId(userName));
	            		forward=RESOURCE_SKILL;            		
	        		}else{
	        			request.setAttribute("uploadFlag", "NO");
	        			forward=ADD_SKILL;
	        		}
	        		
	        	}else{
	        		//request.setAttribute("skillList", dao.getAllSkillData());
	        		forward=LIST_SKILL;
	        	}*/
	        }else{
	        	request.setAttribute("loginMassage", "Please enter valid credential");
	        	forward=LOGIN_PAGE;
	        }
        }catch(CSAMException e){
        	request.setAttribute("loginMassage", "Something went wrong.");
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }      
}
