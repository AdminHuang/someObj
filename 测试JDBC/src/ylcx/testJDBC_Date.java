package ylcx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.text.SimpleAttributeSet;



/**
 * 
 * 测试Java中的三种时间表示
 * @author HUANGW
 *java.sql.Date
 *java.sql.Time
 *java.sql.Timestamp
 */
public class testJDBC_Date {
	
	public static long str2Date(String dateStr){
		DateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		/**
		 * 产生随机数
		 */
		int rand=100000000+new Random().nextInt(100000000);
		
		java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		Timestamp tmp =new Timestamp(System.currentTimeMillis());
	/**
	 * 使用随机数产生一个的随机时间
	 */
		java.sql.Date date_rand=new java.sql.Date(System.currentTimeMillis()-rand);
		Time time_rand=new Time(System.currentTimeMillis()-rand);
		Timestamp tmp_rand =new Timestamp(System.currentTimeMillis()-rand);
		
		/**
		 * 打印当前时间
		 */
		System.out.println("打印当前时间");
		System.out.println(date);
		System.out.println(time);
		System.out.println(tmp);
		/**
		 * 打印随机时间
		 */
	System.out.println("*************************************************");
	System.out.println("打印随机时间");
		System.out.println(date_rand);
		System.out.println(time_rand);
		System.out.println(tmp_rand);
		/**
		 * 实现随机插入一个时间，只要将当前时间加减一个随机数就行
		 */
		
		
		/**
		 * 
		 * 查询数据库中特定时间段的信息
		 */
		
		
		try {
			ResultSet rs;
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			PreparedStatement ps=conn.prepareStatement("select * from student where lastLoginTime>? and lastLoginTime<?");
			
			Timestamp start=new Timestamp(str2Date("2015-4-20 11:10:20"));
			Timestamp end=new Timestamp(str2Date("2015-4-21 12:10:20"));
			
			ps.setObject(1, start);
			ps.setObject(1, end);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"--"+rs.getString("name")+"----"+rs.getTimestamp("lastLoginTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
