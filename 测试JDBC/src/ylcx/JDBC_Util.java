package ylcx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Util {
	
	static Properties pros=null;
	static{
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 获得数据库链接
	 * @return
	 */
	public static Connection getSQlServerConn(){
		try {
			Class.forName(pros.getProperty("connection.driver"));
			return DriverManager.getConnection(pros.getProperty("connection.url"),pros.getProperty("connection.username"),pros.getProperty("connection.password"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	public static Connection getMysqlConn(){
		try {
			Class.forName(pros.getProperty("mysql.driver"));
			return DriverManager.getConnection(pros.getProperty("mysql.url"),pros.getProperty("mysql.username"),pros.getProperty("mysql.password"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	/**
	 * 
	 * 关闭数据库链接
	 */
	public static void close(Connection conn){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(Statement ps){
		try{
			if(ps!=null){
				ps.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs,Statement ps,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(ps!=null){
				ps.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(Statement ps,Connection conn){
		try{
			if(ps!=null){
				ps.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs,Statement ps){
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(ps!=null){
				ps.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
