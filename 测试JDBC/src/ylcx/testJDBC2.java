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
			 * ����addBatchʵ�����ݵ�������
			 * ��������֮ǰӦ���������ó��ֶ��ύ
			 */
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			stat=conn.createStatement();
			conn.setAutoCommit(false);//��������Ϊ�ֶ�
			long start=System.currentTimeMillis();//ִ�п�ʼ��ʱ
			for(int i=1;i<=20000;i++){
			stat.addBatch("insert into student(name,sex,age,grade,score) values('ylcx"+i+"','Ů',20,'2��',100);");
			}//ʵ��������
			stat.executeBatch();//ִ��������
			conn.setAutoCommit(true);//�����Զ��ύ��������
			long end=System.currentTimeMillis();//ִ�н�����ʱ
		System.out.println("����һ�����");
		System.out.println("����ʱ��Ϊ"+(end-start));//����ִ��SQL��仨�ѵ�ʱ��
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
