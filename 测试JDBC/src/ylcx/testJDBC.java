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
			
			/**<�����ڲ�����socket���󣬱ȽϺ�ʱ>
			 * ����conn�������Ӻ�ʱ//����DriverManager��Connection��������ʱ�ܺ�ʱ��
			 * long start=System.currentTimeMillis();
			 */
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			System.out.println(conn);
			
			/**
			 * 	long end=System.currentTimeMillis();
			 * 	System.out.println(end-start+"ms����");
			 */	
			String sql="insert into student(name,sex,age,grade,score) values(?,?,?,?,?);";
			/**
			 * prepareStatementʵ����Statement�ӿڣ�
			 */
			PreparedStatement ps=conn.prepareStatement(sql);//����PrepareStatement�������������Ч�ķ�ֹsqlע�룬���Ҿ���Ԥ������ 
			ps.setObject(1, "ylcx");
			ps.setObject(2, "��");
			ps.setObject(3, "23");
			ps.setObject(4, "2��");
			ps.setObject(5, "100");
			ps.execute();
		System.out.println("����һ�����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
