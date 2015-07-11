package ylcx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class testJDBC {
		/**
		 * @param args
		 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/**<链接内部包含socket对象，比较好时>
			 * 测试conn对象链接耗时//调用DriverManager，Connection创建对象时很耗时的
			 * long start=System.currentTimeMillis();
			 */
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			System.out.println(conn);
			
			/**
			 * 	long end=System.currentTimeMillis();
			 * 	System.out.println(end-start+"ms毫秒");
			 */	
			String sql="insert into student(name,sex,age,grade,score) values(?,?,?,?,?);";
			/**
			 * prepareStatement实现了Statement接口，
			 */
			PreparedStatement ps=conn.prepareStatement(sql);//利用PrepareStatement创建对象可以有效的防止sql注入，并且具有预处理功能 
			ps.setObject(1, "ylcx");
			ps.setObject(2, "男");
			ps.setObject(3, "23");
			ps.setObject(4, "2班");
			ps.setObject(5, "100");
			ps.execute();
		System.out.println("插入一条语句");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
