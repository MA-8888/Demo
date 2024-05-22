package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.data.entity.User;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.form.UserForm;

@Controller
public class UserController {
	// @Autowiredアノテーションを付けると、Spring Bootが自動でインスタンスをInjectします。
	@Autowired
	private UserRepository userRepository;

	// @RequestMapping(path = "/user", method = RequestMethod.GET)の省略版。
	// HTTPのメソッドGETのみ受け付けます。
	@GetMapping("/users")
	// 引数にorg.springframework.ui.Modelを追加
	public String getUsers(Model model) {
		// ユーザーリスト取得処理を追加
		List<User> users = userRepository.findAll();
		// 取得したリストをテンプレートに渡す
		model.addAttribute("A", users);
		return "users";
	}
	
	@GetMapping("/newuser")
	public String getNewUser(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		return "newuser";
	}
}
