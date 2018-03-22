package myspring.user.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class DBTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test @Ignore
	public void connection() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test @Ignore
	public void sqlsession() {
		System.out.println(sqlSession.getConnection());
		UserVO user = new UserVO("yongsnim", "yongs", "남", "서울");
		int cnt = sqlSession.insert("userNS.insertUser", user);
		System.out.println("등록된 건수 " + cnt);
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}
	
	@Test
	public void student() {
		StudentVO student = 
				new StudentVO(1018, "yongs", 34, "1학년", "주간", new DeptVO(20));
		int cnt = sqlSession.update("studentNS.insertStudent", student);
		System.out.println("등록된 건수 " + cnt);
	}
}
