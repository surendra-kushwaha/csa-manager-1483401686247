package com.acit.csam.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean updateSkill(CSAMInfo csamInfo) throws CSAMException{
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
			queryString.append("UPDATE MULTI_SKILLING_DATA set \"SKILL_ROLE\"=?,\"SCORE\"=?, \"CERTIFICATE_NAME\"=?,  \"CERT_UPLOAD_FLAG\"=?,  \"CERTIFICATE_EXTN\"=?, \"CERTIFICATE\"=?"
            		+", \"WORK_LOCATION\"=?,  \"CERTIFICATION_DATE\"=?,  \"CLEARED_FLAG\"=?, \"SECTION1_SCORE\"=?, \"SECTION2_SCORE\"=?, \"SECTION3_SCORE\"=?,"
            		+ " \"SECTION4_SCORE\"=?, \"SECTION5_SCORE\"=?, \"SECTION6_SCORE\"=?,\"UPLOAD_DATE\"=? where \"ENTERPRIZE_ID\"=?");

			
			
			preparedStatement = connection.prepareStatement(queryString.toString());
			//System.out.println("update query String ##"+queryString.toString());
			/*preparedStatement.setString(1, skillInfo.getSkillRole());
			preparedStatement.setString(2, skillInfo.getScore());
			preparedStatement.setString(3, skillInfo.getCertificateName());
            preparedStatement.setString(4, "YES");
            preparedStatement.setString(5,skillInfo.getCertificateExtn());
           // preparedStatement.setBinaryStream(6, skillInfo.getCertificate(),skillInfo.getCertificate().available());
            
            preparedStatement.setString(7, skillInfo.getWorkLocation());
			preparedStatement.setString(8, skillInfo.getCertDate());
            preparedStatement.setString(9, skillInfo.getClear());
            preparedStatement.setString(10,skillInfo.getSection1Score());
            preparedStatement.setString(11, skillInfo.getSection2Score());
            preparedStatement.setString(12, skillInfo.getSection3Score());
			preparedStatement.setString(13, skillInfo.getSection4Score());
            preparedStatement.setString(14, skillInfo.getSection5Score());
            preparedStatement.setString(15,skillInfo.getSection6Score());
            
            String PATTERN="dd-MMM-YYYY";
            SimpleDateFormat dateFormat=new SimpleDateFormat();
            dateFormat.applyPattern(PATTERN);
            String uploadDate=dateFormat.format(Calendar.getInstance().getTime());
            System.out.println("uploadDate##"+uploadDate);
            preparedStatement.setString(16,uploadDate);
            
            preparedStatement.setString(17, skillInfo.getEnterprizeId());*/
    		/*for (int i = 0; i < bindVariables.size(); i++) {
				// variables are indexed from 1 in JDBC
    			int index=9;
    			preparedStatement.setBinaryStream(index+i + 1, bindVariables.get(i),bindVariables.get(i).available());
			}  */  		
            
            
            
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
