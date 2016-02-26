package com.chni.bp88a_server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
    private  static final  String DRIVER=Config.getValue("driver");
    private  static final  String URL =Config.getValue("url");
    private  static final  String USER=Config.getValue("user");
    private  static final  String PWD=Config.getValue("password");
    //数据库连接
    private  static  ThreadLocal<Connection> td=new ThreadLocal<Connection>();
    public static Connection  getConn() throws ClassNotFoundException, SQLException{
   	 Connection conn=td.get();
   		 if(conn==null){
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER,PWD);
//			System.out.println("数据库连接成功OK");
			td.set(conn);
   		 }
			return  conn;	
    }
    /**
	 * 关闭数据源
	 * */
	public static void closeDB(Connection conn) {
		if (conn != null)
			try {
				conn.close();
				td.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void closeDB(Statement stmt ) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void closeDB(PreparedStatement pstmt ) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void closeDB(ResultSet rs ) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static  void  closeDB(ResultSet rs,Statement  stmt,Connection  conn){
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
				td.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static  void  closeDB(ResultSet rs,PreparedStatement pstmt,Connection  conn){
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
				td.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getConn());
	}
}
