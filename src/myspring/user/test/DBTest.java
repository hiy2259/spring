package myspring.user.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class DBTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	UserService userService;

	@Test
	@Ignore
	public void connection() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
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

	@Test @Ignore
	public void student() {
		StudentVO student = new StudentVO(1018, "yongs", 34, "1학년", "주간", new DeptVO(20));
		int cnt = sqlSession.update("studentNS.insertStudent", student);
		System.out.println("등록된 건수 " + cnt);
	}

	@Test @Ignore
	public void service() {
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
		assertThat(user.getName(), is("홍길동"));
		for(UserVO userVo: userService.getUserList()) {
			System.out.println(userVo);
		}
	}
	
	@Test
	public void insert() {
		assertTrue(userService.insertUser(new UserVO("yongsnim", "yongs", "남", "서울")));
		UserVO user = userService.getUser("yongs");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void update() {
		userService.updateUser(new UserVO("yongsnim", "yongs", "남", "서울"));
		UserVO user = userService.getUser("yongs");
		System.out.println(user);
	}
}
