package ylcx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {

	/**
	 * ����JDBC�������ݿ⣬
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//Object[] objs=null;//�״ν�rs�����ݷ�װ��������ȥ,�ʺ��ڲ�ѯ���ؽ��ֻ��һ������
		List<Object[]> list=new ArrayList<Object[]>();//�ٴη�װ�����Է��ض�������
		conn=JDBC_Util.getMysqlConn();
		try {
			ps=conn.prepareStatement("select * from student where lastLoginTime>? and lastLoginTime<?");
			//ps=conn.prepareStatement("select * from student_1 where name=?");
			ps.setObject(1, "2015-05-23 01:47:38.0");
			ps.setObject(2, "2015-05-23 11:47:38.0");
			//ps.setObject(1, "����");
			rs=ps.executeQuery();
			while(rs.next()){
				/**
				 * rs�α�����������ݿ��ѯ���ݣ��������һ��������ִ�У����򷵻ؽ����
				 * �����������һ�����飬���������������ȡ��������е�����
				 */
				Object[] objs=new Object[3];
				//System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getTimestamp(3));
				objs[0]=rs.getString(1);
				objs[1]=rs.getString(2);
				objs[2]=rs.getString(3);
				
				list.add(objs);//��Object���󱣴浽List��ȥ
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_Util.close(rs, ps, conn);
		}
		for(Object[] objs:list){//��������List�����飬��ӡ���
			System.out.println(""+objs[0]+"----"+objs[1]+"----"+objs[2]);
			}
	}

}
