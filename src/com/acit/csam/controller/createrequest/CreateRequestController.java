package com.acit.csam.controller.createrequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.acit.csam.dao.CSAManagerDao;
import com.acit.csam.exception.CSAMException;
import com.acit.csam.model.CSAMInfo;
 
@WebServlet("/createRequestController")
public class CreateRequestController extends HttpServlet {
       
    private CSAManagerDao dao;
    
    public CreateRequestController() {
        super();
        dao = new CSAManagerDao();
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException { 
        final String SKILL_UPLOAD = "/createRequestForm.jsp";
       //final String RESOURCE_SKILL="/resourceSkillInfo.jsp";
        CSAMInfo csamInfo=new CSAMInfo();        
        try {
        	       	       	
        	
        	String cloudService=request.getParameter("cloudService");
        	String lob=request.getParameter("lob");
        	String priority=request.getParameter("priority");
        	String cloudServiceUrl=request.getParameter("cloudServiceUrl");
        	String businessDesc=request.getParameter("businessDesc");
        	String cos=request.getParameter("cos");
        	
        	csamInfo.setCloudService(cloudService);
        	csamInfo.setBusinessDesc(businessDesc);
        	csamInfo.setCos(cos);
        	csamInfo.setPriority(priority);
        	csamInfo.setCloudServiceUrl(cloudServiceUrl);
			csamInfo.setLob(lob);
            String forward="";
            try{
                dao.createCSAR(csamInfo);
                request.setAttribute("addFlag","addSuccess");                
        		//forward=RESOURCE_SKILL;
        		//if(employeeRole.equalsIgnoreCase("admin")){
        			//request.setAttribute("skillList", dao.getFormDataByEntId(enterprizeId));
        		//}/*else{
        			//forward=RESOURCE_SKILL;
        			//request.setAttribute("skillList", dao.getFormDataByEntId(enterprizeId));
        		//}*/
        		//request.setAttribute("uploadFlag", "YES");
        		//System.out.println("Add Controller ent ID"+enterprizeId);
        		//request.setAttribute("skillList", dao.getFormDataByEntId(enterprizeId));
            }catch(CSAMException e){
            	forward=SKILL_UPLOAD;
            	String errorMessage=null;
            	if(e.getErrorCode()==-803){
            		//System.out.println("Controller SQL ERROR CODE"+e.getErrorCode());
            		errorMessage=getProperties("SQL_ERROR001");
            		request.setAttribute("addFlag", errorMessage);  
            		//request.setAttribute("addFlag", "addFailure"); 
            	}else{
            		//forward=BULK_UPLOAD;
            		errorMessage=getProperties("SQL_ERROR003");
            		request.setAttribute("addFlag", errorMessage);
            		//request.setAttribute("addFlag", "SystemError");
            	}
            	//String validationError=getProperties(e.getErrorCode());
            	//System.out.println("Error code"+getProperties(e.getErrorCode()));
            	//System.out.println("Error message"+getProperties(e.getErrorCode()));
            	//request.setAttribute("addFlag", validationError);
            }
        	
                    	       	
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
        	response.getWriter().append("Records Added to DB");
        }  catch(Exception e) { 
        	e.printStackTrace();
        }
    }
    
    
    public String getProperties(String key){
    	ResourceBundle bundle = ResourceBundle.getBundle("resources.messages", Locale.US);
    	System.out.println("Key:"+bundle.getString(key));
    	return bundle.getString(key);		
    }
}