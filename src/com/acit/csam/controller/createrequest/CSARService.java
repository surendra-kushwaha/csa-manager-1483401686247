package com.acit.csam.controller.createrequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.acit.csam.dao.CSAManagerDao;
import com.acit.csam.model.CSAMInfo;
import com.acit.csam.model.Comments;
import com.acit.csam.util.Utility;
/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/CSARRequest")
public class CSARService extends HttpServlet {
    private static final long serialVersionUID = 1L;
private CSAManagerDao dao;
    
    public CSARService() {
        super();
        dao = new CSAManagerDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setContentType("text/html");
        String responseBoard = "";
        SimpleServlet http = new SimpleServlet();
       
		String searchRequest = request.getParameter("req");
		System.out.println("search request is------->"+searchRequest);
		if(searchRequest.equals("create")){
			Utility.CARD_TITLE = request.getParameter("title");
			Utility.CARD_DESCRIPTION = request.getParameter("description");
			Utility.CARD_PRIORITY = http.getPriority(request.getParameter("priority"));
			Utility.CARD_CLASS_OF_SERVICE_ID = http.getClassOfService(request.getParameter("classservice"));
			responseBoard = http.createCard();
		}else if(searchRequest.equals("view")){
			responseBoard = http.getAllCards();
		}else if(searchRequest.equals("carddetails")){
			System.out.println("search request is 222------->"+searchRequest);
			Utility.SEARCH_BY_CARD_ID = request.getParameter("cardid");
			System.out.println("Utility.SEARCH_BY_CARD_ID request is 222------->"+Utility.SEARCH_BY_CARD_ID);
			responseBoard = http.getCardByID();
			
			JSONObject json = new JSONObject(responseBoard);
			JSONArray json1 = (JSONArray)json.get("ReplyData");
			JSONObject json2 = (JSONObject) json1.get(0);
			Utility.SEARCH_BY_BOARD_ID = ""+json2.getInt("BoardId");
			Utility.LANE_ID = ""+json2.getInt("LaneId");
			Utility.LANE_TITLE = json2.getString("LaneTitle");
			String lastMove = json2.getString("LastMove");
			String lastComments = getCardComments();
			responseBoard = responseBoard+","+lastComments;
			
		}
		
        response.getWriter().print(responseBoard);*/
    	doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 response.setContentType("text/html");
         String responseBoard = "";
         CSARService http = new CSARService();
         //final String VIEW_STATUS = "CSARRequest?req=view";
         final String VIEW_STATUS = "/createRequestForm.jsp";
 		String searchRequest = request.getParameter("req");
 		HttpSession session = request.getSession();
    	//if(requestorId==null){
    		String userName=(String)session.getAttribute("userName");
    		System.out.println("userName retrieved::"+userName);
    	//}
 		//System.out.println("search request is------->"+searchRequest);
 		if(searchRequest.equals("create")){
 			/*Utility.CARD_TITLE = request.getParameter("title");
 			Utility.CARD_DESCRIPTION = request.getParameter("description");
 			Utility.CARD_PRIORITY = http.getPriority(request.getParameter("priority"));
 			Utility.CARD_CLASS_OF_SERVICE_ID = http.getClassOfService(request.getParameter("classservice"));*/
 			
 			String cloudService=request.getParameter("cloudService");
        	String lob=request.getParameter("lob");
        	String priority=request.getParameter("priority");
        	String cloudServiceUrl=request.getParameter("cloudServiceUrl");
        	String businessDesc=request.getParameter("businessDesc");
        	String cos=request.getParameter("cos");
        	String requestorId=request.getParameter("userId");
        	if(requestorId==null){
        		requestorId=userName;
        	}
        	System.out.println("userId recieved in ontroller  "+requestorId);
        	CSAMInfo csamInfo=new CSAMInfo();
        	csamInfo.setCloudService(cloudService);
        	csamInfo.setBusinessDesc(businessDesc);
        	csamInfo.setCos(cos);
        	csamInfo.setPriority(priority);
        	csamInfo.setCloudServiceUrl(cloudServiceUrl);
			csamInfo.setLob(lob);			
			csamInfo.setCardTitle(requestorId+" "+cloudService+" "+lob);
			csamInfo.setRequesterId(requestorId);
			System.out.println("Card Title##"+csamInfo.getCardTitle());
 			Utility.CARD_TITLE = requestorId+" "+cloudService+" "+lob;
 			Utility.CARD_DESCRIPTION = businessDesc;
 			Utility.CARD_PRIORITY = http.getPriority(priority);
 			Utility.CARD_CLASS_OF_SERVICE_ID = http.getClassOfService(cos);
 			Utility.CLOUD_SERVICE_URL = cloudServiceUrl;
 			responseBoard = http.createCard();
 			 
 			//Parse response
 			try{
 			JSONObject json = new JSONObject(responseBoard);
 			JSONArray json1 = (JSONArray)json.get("ReplyData");
 			JSONObject json2 = (JSONObject) json1.get(0);
 			//Utility.SEARCH_BY_BOARD_ID = ""+json2.getInt("BoardId");
 			//Utility.LANE_ID = ""+json2.getInt("LaneId");
 			//Utility.LANE_TITLE = json2.getString("LaneTitle");
 			//String lastMove = json2.getString("LastMove");
 			String cardId=json2.getString("CardId");
 			System.out.println("CardId recieved in Response ##"+cardId);
 			csamInfo.setCardId(cardId);			
			
			boolean status=dao.createCSAR(csamInfo);
 			if(status){
 				
 				System.out.println("data added successfully ");
 				//response.getWriter().append("Data saved to DB "+status);
 				//dao.getRequestaList(requestorId);
 				//request.setAttribute("RequestList", dao.getRequestaList(requestorId));
 				request.setAttribute("addFlag", "addSuccess");
 				//request.setAttribute("CardsList", http.getAllCards());
 				
 				
 				/*test in UI
 				List<CSAMInfo> reqList=null; 				
 				if(request.getAttribute("RequestList")!=null){
 					reqList = (List)request.getAttribute("RequestList");
 					System.out.println("reqList  ##"+reqList.toString());
	 			   Iterator itr=reqList.iterator();
	 			   while(itr.hasNext()){
	 				  CSAMInfo skillInfo=(CSAMInfo)itr.next();
	 				  System.out.println("from list cluodService@@"+skillInfo.getCloudService());
	 				 System.out.println("from list cardId@@"+skillInfo.getCardId());
	 			   }
 			   }*/
 			   
 				
 			}
 			}catch(Exception e){
 				System.out.println(e);
 			}
 			//request.setAttribute("CardsList", http.getAllCards());
 			RequestDispatcher view = request.getRequestDispatcher(VIEW_STATUS);
            view.forward(request, response);
 			
 		}else if(searchRequest.equals("view")){
 			//Utility.SEARCH_TEXT =  request.getParameter("userId");///////////////New line added by Bibek
 			if(userName==null){
 				userName=request.getParameter("userId");
 			}
 			Utility.SEARCH_TEXT =  userName;
 			responseBoard = http.getCardsByBoard();///////////////New line added by Bibek
 			System.out.println("List of Request Status::"+responseBoard);
 			try{
 			JSONObject commentsJson = new JSONObject(responseBoard);
 			System.out.println("hi2");
 			JSONArray commentsJson1 = (JSONArray)commentsJson.get("ReplyData");
 			JSONObject json2 = (JSONObject) commentsJson1.get(0);
 			JSONArray commentsJson3 = (JSONArray)json2.get("Results");
 			List<CSAMInfo> cardList=new ArrayList<CSAMInfo>();
 			for(int i=0; i<commentsJson3.length();i++){
 				JSONObject commentsJson2 = (JSONObject) commentsJson3.get(i);
 				System.out.println("Title from view##"+commentsJson2.getString("Title"));
 				String cardId=commentsJson2.getString("Id");
 				String priority=commentsJson2.getString("PriorityText");
 	        	System.out.println("hi6 "+priority);
 	        	String description=commentsJson2.getString("Description");
 	        	//String cloudServiceUrl=request.getParameter("cloudServiceUrl");
 	        	//String businessDesc=request.getParameter("businessDesc");
 	        	String cos=commentsJson2.getString("ClassOfServiceTitle");
 	        	//String requestorId=request.getParameter("userId");
 	        	String status=commentsJson2.getString("LaneTitle");
 	        	String lastUpdatedDate=commentsJson2.getString("LastActivity");  
 	        	System.out.println("lastUpdatedDate  "+lastUpdatedDate);
 	        	String assignedTo=commentsJson2.getString("AssignedUserName");
 	        	//String cardId=commentsJson2.getString("Id");
 	        	CSAMInfo csamInfo=new CSAMInfo();
 	        	csamInfo=dao.getCardDetails(cardId);
 	        	csamInfo.setAssignedTo(assignedTo);
 	        	csamInfo.setCardStatus(status);
 	        	csamInfo.setLastUpdatedDate(lastUpdatedDate);
 	        	csamInfo.setPriority(priority);
 	        	csamInfo.setBusinessDesc(description);
 	        	csamInfo.setCardId(cardId);
 	        	csamInfo.setCos(cos);
 	        	cardList.add(csamInfo);
 				
 			}
 			
 			request.setAttribute("cardList", cardList);
 			//response.getWriter().append(responseBoard);
 			}catch(Exception e){
 				System.out.println("exception occured "+e);
 			}
 			RequestDispatcher view = request.getRequestDispatcher("/viewListForm.jsp");
            view.forward(request, response);
 			//responseBoard = http.getAllCards();
 		}else if(searchRequest.equals("carddetails")){
 			//System.out.println("search request is 222------->"+searchRequest);
 			Utility.SEARCH_BY_CARD_ID = request.getParameter("cardid");
 			System.out.println("inside Card Details method"+request.getParameter("cardid"));
 			try{
 			responseBoard = http.getCardByID();
 			System.out.println("hi1");
 			JSONObject json = new JSONObject(responseBoard);
 			System.out.println("hi2");
 			JSONArray json1 = (JSONArray)json.get("ReplyData");
 			JSONObject json2 = (JSONObject) json1.get(0);
 			System.out.println("hi3");
 			Utility.SEARCH_BY_BOARD_ID = ""+json2.getInt("BoardId");
 			Utility.LANE_ID = ""+json2.getInt("LaneId");
 			System.out.println("hi4");
 			Utility.LANE_TITLE = json2.getString("LaneTitle");
 			System.out.println("hi5 "+json2.getString("LaneTitle"));
 			String lastMove = json2.getString("LastMove");
 			
 			//String cloudService=request.getParameter("cloudService");
        	//String lob=request.getParameter("lob");
        	String priority=json2.getString("PriorityText");
        	System.out.println("hi6 "+priority);
        	String description=json2.getString("Description");
        	//String cloudServiceUrl=request.getParameter("cloudServiceUrl");
        	//String businessDesc=request.getParameter("businessDesc");
        	String cos=json2.getString("ClassOfServiceTitle");
        	//String requestorId=request.getParameter("userId");
        	String status=json2.getString("LaneTitle");
        	String lastUpdatedDate=json2.getString("LastActivity");  
        	System.out.println("lastUpdatedDate  "+lastUpdatedDate);
        	String assignedTo=json2.getString("AssignedUserName");
        	CSAMInfo csamInfo=new CSAMInfo();
        	csamInfo=dao.getCardDetails(request.getParameter("cardid"));
        	csamInfo.setAssignedTo(assignedTo);
        	csamInfo.setCardStatus(status);
        	csamInfo.setLastUpdatedDate(lastUpdatedDate);
        	csamInfo.setPriority(priority);
        	csamInfo.setBusinessDesc(description);
        	csamInfo.setCos(cos);
        	System.out.println("Status ## "+status);
        	System.out.println("priority  "+priority);
        	
        	String lastComments = getCardComments();
 			responseBoard = responseBoard+","+lastComments;
 			
 			JSONObject commentsJson = new JSONObject(lastComments);
 			System.out.println("hi2");
 			JSONArray commentsJson1 = (JSONArray)commentsJson.get("ReplyData");
 			System.out.println("Hi3##"+commentsJson1.toString());
 			List<Comments> commentList=new ArrayList<Comments>();
 			JSONArray json22 = (JSONArray) commentsJson1.get(0);
 			System.out.println("Hi3#A#"+json22);
 			for(int i=0; i<json22.length();i++){
 				System.out.println("hi4");
 				JSONObject commentsJson2 = (JSONObject) json22.get(i);
 				System.out.println("hi5");
 				Comments comment=new Comments();
 				comment.setPostedBy(commentsJson2.getString("PostedByFullName"));
 				comment.setPostDate(commentsJson2.getString("PostDate"));
 				comment.setComment(commentsJson2.getString("Text"));
 				commentList.add(comment);
 			}
 			
 			//System.out.println("CardDetails  $$"+responseBoard);
 			
 			//System.out.println("Comments  $$"+lastComments);
 			
 			//dao.getCardDetails(request.getParameter("cardid"));
 			request.setAttribute("CommentsList", commentList);
 			request.setAttribute("cardDeatils", csamInfo);
        	
 			}catch(Exception e){
 				System.out.println("Exception occured"+e);
 			}
 			
 			RequestDispatcher view = request.getRequestDispatcher("/viewFormDetails.jsp");
            view.forward(request, response);
 			
 		}
 		
         response.getWriter().print(responseBoard);
    }
    
    private String getPriority(String priority){
    	if(priority.equalsIgnoreCase("LOW"))
    		Utility.CARD_PRIORITY="0";
    	else if(priority.equalsIgnoreCase("NORMAL"))
    		Utility.CARD_PRIORITY="1";
    	else if(priority.equalsIgnoreCase("HIGH"))
    		Utility.CARD_PRIORITY="2";
    	else if(priority.equalsIgnoreCase("CRITICAL"))
    		Utility.CARD_PRIORITY="3";
    	return Utility.CARD_PRIORITY;
    	
    }
    
    private String getClassOfService(String cardClassOfServiceID){
    	if(cardClassOfServiceID.equalsIgnoreCase("Date Dependent"))
    		Utility.CARD_CLASS_OF_SERVICE_ID="428201710";
    	else if(cardClassOfServiceID.equalsIgnoreCase("Expedite"))
    		Utility.CARD_CLASS_OF_SERVICE_ID="428201711";
    	else if(cardClassOfServiceID.equalsIgnoreCase("Regulatory"))
    		Utility.CARD_CLASS_OF_SERVICE_ID="428201712";
    	else if(cardClassOfServiceID.equalsIgnoreCase("Standard"))
    		Utility.CARD_CLASS_OF_SERVICE_ID="428201713";
    	return Utility.CARD_CLASS_OF_SERVICE_ID;
    	
    }
    
    private String getAllBoards()  {

    	StringBuffer result = null;
		try{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(Utility.ALL_BOARD_URL);

		// add request header
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "Basic " + encoding);
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + Utility.ALL_BOARD_URL);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			System.out.println("Exception is---"+e.toString());
		}
		return result.toString();
	}
    
    private String createCard() {

		String url = Utility.CREATE_CARD_URL+Utility.BOARD_ID+Utility.ADD_CARD+Utility.ADD_LANE+Utility.LANE_ID+Utility.POSITION+Utility.DEFAULI_POSITION;
		JSONObject json = new JSONObject();
		StringBuffer result = null;
		try{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Accept", "application/json");
        post.addHeader("Authorization", "Basic " + encoding);
		json.put("Title", Utility.CARD_TITLE);
		json.put("Description", Utility.CARD_DESCRIPTION);
		json.put("TypeId", Utility.TYPE_ID);
		json.put("Priority", Utility.CARD_PRIORITY);
		json.put("ExternalSystemUrl", Utility.CLOUD_SERVICE_URL );
		json.put("ClassOfServiceId", Utility.CARD_CLASS_OF_SERVICE_ID);
		StringEntity params = new StringEntity(json.toString());

		post.setEntity(params);

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " +
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		}catch(Exception e){
			System.out.println("Exception in adding cards---"+e.toString());
		}
		System.out.println(result.toString());
		return result.toString();

	}
    
    private String getAllCards()  {

    	StringBuffer result = null;
    	JSONObject json = new JSONObject();
		try{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(Utility.SEARCH_ALL_CARD_URL);

		// add request header
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
		post.addHeader("Content-Type", "application/json");
		post.addHeader("Accept", "application/json");
		post.addHeader("Authorization", "Basic " + encoding);
		json.put("SearchTerm",Utility.SEARCH_TEXT);
		json.put("SearchInBacklog",true);
		json.put("SearchInBoard",true);
		json.put("SearchInRecentArchive",true);
		json.put("SearchInOldArchive",true);
		json.put("IncludeComments",true);
		json.put("IncludeTags",true);
		json.put("Page",2);
		json.put("MaxResults",50);
		StringEntity params = new StringEntity(json.toString());

		post.setEntity(params);
		
		HttpResponse response = client.execute(post);

		System.out.println("\nSending 'GET' request to URL : " + Utility.SEARCH_ALL_CARD_URL);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			System.out.println("Exception is---"+e.toString());
		}
		return result.toString();
	}
    private String getCardsByBoard()  {////////////////Method name changed from getAllBoards to getCardsByBoard

    	StringBuffer result = null;
		JSONObject json = new JSONObject();//////////////New line added
		try{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(Utility.SEARCH_BY_BOARD_URL+Utility.BOARD_ID+"/searchcards");///////////The parametr changed from Utility.ALL_BOARD_URL.Method also changed HttpGet to HttpPost

		// add request header
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
		post.addHeader("Content-Type", "application/json");/////////////changed the object from request to post 
		post.addHeader("Accept", "application/json");/////////////changed the object from request to post
		post.addHeader("Authorization", "Basic " + encoding);/////////////changed the object from request to post
		/////////////////////Completely new added///////////////////////
		json.put("SearchTerm",Utility.SEARCH_TEXT);
		json.put("SearchInBacklog",true);
		json.put("SearchInBoard",true);
		json.put("SearchInRecentArchive",true);
		json.put("SearchInOldArchive",true);
		json.put("IncludeComments",true);
		json.put("IncludeTags",true);
		json.put("Page",1);
		json.put("MaxResults",50);
		StringEntity params = new StringEntity(json.toString());
		post.setEntity(params);
		/////////////////////ENDDDD///////////////////////
		HttpResponse response = client.execute(post);

		System.out.println("\nSending 'GET' request to URL : " + Utility.ALL_BOARD_URL);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			System.out.println("Exception is---"+e.toString());
		}
		return result.toString();
	}
    private String getCardByID()  {

    	StringBuffer result = null;
		try{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(Utility.SEARCH_BY_CARD_URL+Utility.SEARCH_BY_CARD_ID);

		// add request header
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "Basic " + encoding);
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + Utility.SEARCH_BY_CARD_URL);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			System.out.println("Exception is---"+e.toString());
		}
		return result.toString();
	}
    
    private String getCardComments()  {

    	StringBuffer result = null;
		try{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(Utility.SEARCH_CARD_COMMENTS_URL+Utility.SEARCH_BY_BOARD_ID+"/"+Utility.SEARCH_BY_CARD_ID);

		// add request header
		Base64 b = new Base64();
        String encoding = b.encodeAsString(new String(Utility.USER_NAME+":"+Utility.PASSWORD).getBytes());
		
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "Basic " + encoding);
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + Utility.SEARCH_CARD_COMMENTS_URL);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			System.out.println("Exception is---"+e.toString());
		}
		return result.toString();
	}

}
