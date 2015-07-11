package ylcx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {

	/**
	 * 测试JDBC链接数据库，
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//Object[] objs=null;//首次将rs中内容封装到数组中去,适合于查询返回结果只有一条数据
		List<Object[]> list=new ArrayList<Object[]>();//再次封装，可以返回多条数据
		conn=JDBC_Util.getMysqlConn();
		try {
			ps=conn.prepareStatement("select * from student where lastLoginTime>? and lastLoginTime<?");
			//ps=conn.prepareStatement("select * from student_1 where name=?");
			ps.setObject(1, "2015-05-23 01:47:38.0");
			ps.setObject(2, "2015-05-23 11:47:38.0");
			//ps.setObject(1, "张三");
			rs=ps.executeQuery();
			while(rs.next()){
				/**
				 * rs游标遍历整个数据库查询数据，如果有下一条，继续执行，否则返回结果集
				 * 结果集类似于一个数组，可以利用下面语句取出结果集中的数据
				 */
				Object[] objs=new Object[3];
				//System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getTimestamp(3));
				objs[0]=rs.getString(1);
				objs[1]=rs.getString(2);
				objs[2]=rs.getString(3);
				
				list.add(objs);//将Object对象保存到List中去
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_Util.close(rs, ps, conn);
		}
		for(Object[] objs:list){//遍历整个List大数组，打印结果
			System.out.println(""+objs[0]+"----"+objs[1]+"----"+objs[2]);
			}
	}

}
