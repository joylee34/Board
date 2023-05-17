package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.service.LoginService;
import com.spring.demo.vo.MemberVO;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private LoginService ls;

	@GetMapping("/login/{id}/{pwd}")
	public String login(@PathVariable String id, @PathVariable String pwd) {

		MemberVO mem = new MemberVO();
		mem.setMemid(id);
		mem.setPwd(pwd);
		if (ls.login(mem))
			return "thymeleaf/board/addform";
		else
			return null;

	}
}
