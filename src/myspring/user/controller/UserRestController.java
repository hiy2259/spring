package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public Boolean insertUser(@RequestBody UserVO user) {
		return userService.insertUser(user);
	}

	 @RequestMapping(value = "/users", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	 @ResponseBody
	 public Boolean updateUser(@RequestBody UserVO user) {
		 if (user != null) {
			 userService.updateUser(user);
			 return Boolean.TRUE;
		 } else {
			 return Boolean.FALSE;
		 }
	 }
	
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	 @ResponseBody
	 public Boolean deleteUser(@PathVariable String id) {
		 if (id != null) {
			 userService.deleteUser(id);
			 return Boolean.TRUE;
		 } else {
			 return Boolean.FALSE;
		 }
	 }
	 
	 @RequestMapping(value = "/usersXml", method = RequestMethod.GET)
	 @ResponseBody
	 public UserVOXML getUserListXml() {
		 UserVOXML xml = new UserVOXML("success", userService.getUserList());
		 return xml;
	 }
}
