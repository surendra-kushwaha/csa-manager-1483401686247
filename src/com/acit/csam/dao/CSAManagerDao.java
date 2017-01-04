package com.acit.csam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.acit.csam.exception.CSAMException;
import com.acit.csam.model.CSAMInfo;
import com.acit.csam.util.DataBase;

public class CSAManagerDao {

	private Connection connection;

	public CSAManagerDao() {
		connection = DataBase.getInstance().getConnection();
		// connection = null;
	}
    //*** updatePolicy method updated by Surendra ****** //
    public boolean createCSAR(CSAMInfo csamInfo) throws CSAMException{
    	boolean updateSuccessFlag=false;
    	PreparedStatement preparedStatement=null;
       //System.out.println("In updatePolicy - Start ");
    	try {
    		if ((connection == null) || connection.isClosed() ) {
				//con.DriverManager.getConnection(...);
				connection =  DataBase.getInstance().getConnection();
		    }
    		//List<InputStream> bindVariables = new ArrayList<InputStream>();
    		StringBuffer queryString = new StringBuffer();
			queryString.append("INSERT INTO CSAR (\"ID\",\"REQUESTOR_ID\",\"CLOUD_SERVICE\",\"PRIORITY\",\"BUSSINESS_DESC\","
					+ "\"CoS\",\"CLOUD_SERVICE_URL\",\"CARD_TITLE\",\"CARD_ID\",\"CREATED_DATE\",\"LOB\")"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)");

			
			
			preparedStatement = connection.prepareStatement(queryString.toString());
			//System.out.println("update query String ##"+queryString.toString());
			preparedStatement.setString(1, System.currentTimeMillis()+"");
			preparedStatement.setString(2, csamInfo.getRequesterId());
			preparedStatement.setString(3, csamInfo.getCloudService());
            preparedStatement.setString(4, csamInfo.getPriority());
            preparedStatement.setString(5,csamInfo.getBusinessDesc());
            preparedStatement.setString(6, csamInfo.getCos());
            
            preparedStatement.setString(7, csamInfo.getCloudServiceUrl());
			preparedStatement.setString(8, csamInfo.getCardTitle());
            preparedStatement.setString(9, csamInfo.getCardId());
            preparedStatement.setString(10,new Date().toString());
            preparedStatement.setString(11, csamInfo.getLob());
            
            int updateflag=preparedStatement.executeUpdate();
            if(updateflag>0){
            	System.out.println("updateFlag"+updateflag);
            	updateSuccessFlag=true;
            }
            //connection.commit();            
        }catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new CSAMException(e.getErrorCode());
			
		}  catch (Exception e) {
            e.printStackTrace();
        }finally{
        	close(null,preparedStatement,connection);
        }
    	return updateSuccessFlag;
    }


	/*public void uploadForm(PolicyInfo policyInfo) throws FormsExplorerException {
		PreparedStatement pstmt=null;
		try {
			PolicyInfo pInfo = policyInfo;			
				String insertStr = "INSERT INTO \"FORMS_EXPLORER_DATA\" (\"FORM_NO\",\"DESCRIPTION\",\"BUSINESS_TYPE\",\"LOB\",\"MULTI_STATE\",\"STATE\",\"FORM_TYPE\",\"MANDATORY\","
						+ "\"PORTFOLIO\",\"SOURCE\",\"SOURCE_DOC\",\"SOURCE_PDF\",\"DOC_EXTENTION\")"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
				pstmt = connection.prepareStatement(insertStr);
				System.out.println("inserting to DB uploadDocuments@:");
	
				pstmt.setString(1, pInfo.getFormNo());
				pstmt.setString(2, pInfo.getDescription());
				pstmt.setString(3, pInfo.getBusinessType());
				pstmt.setString(4, pInfo.getLob());
				pstmt.setString(5, pInfo.getMultiState());
				pstmt.setString(6, pInfo.getState());
				pstmt.setString(7, pInfo.getFormType());
				pstmt.setString(8, pInfo.getMandatory());
				pstmt.setString(9, pInfo.getPortfolio());
				pstmt.setString(10, pInfo.getSource());
				InputStream docStream = pInfo.getDocStream();
				int docLength = 0;
	
				if (docStream != null) {
					docLength = docStream.available();
					// fetches input stream of the upload file for the blob column
					pstmt.setBinaryStream(11, docStream, docLength);
					//docStream.close();
					// pstmt.setObject(1, inputStream,length);
				}
	
				InputStream pdfStream = pInfo.getPdfStream();
				int pdfLength = 0;
				if (pdfStream != null) {
					pdfLength = pdfStream.available();
					// fetches input stream of the upload file for the blob column
					pstmt.setBinaryStream(12, pdfStream, pdfLength);
					//pdfStream.close();
					// pstmt.setObject(1, inputStream,length);
				}
				
				pstmt.setString(13, pInfo.getDocExtention());
				// sends the statement to the database server
				//int row = pstmt.executeUpdate();
				pstmt.executeUpdate();
				
		} catch (SQLException e) {
			
			throw new FormsExplorerException(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			close(null,pstmt);
		}
		//return successFlag;
	}*/

	public boolean validateUser(String userId, String password) throws CSAMException  {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			if ((connection == null) || connection.isClosed() ) {
				//con.DriverManager.getConnection(...);
				connection =  DataBase.getInstance().getConnection();
		    }
			ps = connection
					.prepareStatement("select * from USERS where USERID=? and PASSWORD=? ");
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
			throw new CSAMException(ex.getErrorCode());
		}finally{
			close(rs,ps,connection);
		}
		//return false;
	}
	
	/*public SkillInfo getUserDetails(String userId) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		SkillInfo skillInfo=new SkillInfo();
		try {
			if ((connection == null) || connection.isClosed() ) {
				//con.DriverManager.getConnection(...);
				connection =  DataBase.getInstance().getConnection();
		    }
			ps = connection
					.prepareStatement("select * from \"MULTI_SKILLING_DATA\" where \"ENTERPRIZE_ID\"=?");
			ps.setString(1, userId);
			//ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()){
				skillInfo.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				skillInfo.setEnterprizeId(rs.getString("ENTERPRIZE_ID"));
				skillInfo.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				skillInfo.setEmployeeRole(rs.getString("EMPLOYEE_ROLE"));
				skillInfo.setSkillRole(rs.getString("SKILL_ROLE"));
				skillInfo.setCertUploadFlag(rs.getString("CERT_UPLOAD_FLAG"));
				skillInfo.setWorkLocation(rs.getString("WORK_LOCATION"));
			} 
			System.out.println("skillInfo##"+skillInfo);
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}finally{
			close(rs,ps,connection);
		}
		return skillInfo;
	}*/
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if (rs!=null){
			try{
				rs.close();
			}
			catch(SQLException e){
				System.out.println("The result set cannot be closed."+e);
			}
		}
		if (pstmt != null){
			try{
				pstmt.close();
			} catch (SQLException e){
				System.out.println("The prepared statement cannot be closed."+e);
			}
		}
		if(conn != null){
			try{
				conn.close();
			} catch (SQLException e){
				System.out.println("The data source connection cannot be closed."+e);
			}
		}

	}
	public void close(ResultSet rs, PreparedStatement pstmt){
		if (rs!=null){
			try{
				rs.close();
			}
			catch(SQLException e){
				System.out.println("The result set cannot be closed."+e);
			}
		}else if (pstmt != null){
			try{
				pstmt.close();
			} catch (SQLException e){
				System.out.println("The prepared statement cannot be closed."+e);
			}
		}
	}
}
