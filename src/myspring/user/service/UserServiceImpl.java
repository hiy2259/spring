package myspring.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public Boolean insertUser(UserVO user) {
		int cnt = userdao.insert(user);

		if (cnt == 1) {
			return true;
		}

		return false;
	}

	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		userdao.delete(id);
		
	}

	@Override
	public UserVO getUser(String id) {
		return userdao.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		userdao.update(user);
	}
}
