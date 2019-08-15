package Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Entity.Emp;
import dao.IEmpDao;
import util.MybatisInitial;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("aaaa");
		
//		String resource ="mybatis-config.xml";
//		InputStream is=null;
//		SqlSessionFactory factory=null;
//		SqlSession session=null;
//		try {
//			is=Resources.getResourceAsStream(resource);
//			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//			factory=builder.build(is);
//			session=factory.openSession();
//			List<Emp> empList= session.selectList("Entity.Emp.selectEnmpAll");
//			for (Emp emp : empList) {
//				System.out.println(emp.getEname());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Å×³ö£¡£¡");
//		}
//		
		MybatisInitial in=new MybatisInitial();
		SqlSession session=in.getSession();
		IEmpDao empDao=session.getMapper(IEmpDao.class);
		List<Emp> empList =empDao.findbyid(7369);
		for (Emp emp : empList) {
			System.out.println(emp.getEname());
		}
		Emp emp =new Emp();
		emp.setEmpno(111);
		emp.setEname("xiaoming");
		boolean b =empDao.inser(emp);
		session.commit();
		System.out.println(b);
		
		
	}
}
