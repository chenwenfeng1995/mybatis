package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisInitial {

	private static String resource ="mybatis-config.xml";
	private static InputStream is=null;
	private static SqlSessionFactory factory=null;
	private static ThreadLocal<SqlSession> threadlocal =new ThreadLocal<SqlSession>();
	
	static {
		try {
			is=Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		    factory=builder.build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	public  static SqlSession getSession() {
		SqlSession session =threadlocal.get();
		if(session==null) {
			session=factory.openSession();
		}
		threadlocal.set(session);
		return session;
		
	}
	public static void closeSession() {
		SqlSession session =threadlocal.get();
		if(session!=null) {
			session=factory.openSession();
		}
		threadlocal.set(null);
	}
}