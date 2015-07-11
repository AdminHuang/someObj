package ylcx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class testJDBC2 {
		/**
		 * @param args
		 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement stat=null;
		try {
			/**
			 * 利用addBatch实现数据的批处理
			 * 在批处理之前应将事物设置成手动提交
			 */
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			stat=conn.createStatement();
			conn.setAutoCommit(false);//设置事物为手动
			long start=System.currentTimeMillis();//执行开始计时
			for(int i=1;i<=20000;i++){
			stat.addBatch("insert into student(name,sex,age,grade,score) values('ylcx"+i+"','女',20,'2班',100);");
			}//实现批处理
			stat.executeBatch();//执行批处理
			conn.setAutoCommit(true);//设置自动提交处理事物
			long end=System.currentTimeMillis();//执行结束计时
		System.out.println("插入一条语句");
		System.out.println("花费时间为"+(end-start));//计算执行SQL语句花费的时间
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
