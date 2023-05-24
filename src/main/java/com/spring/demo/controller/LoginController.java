package com.spring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.demo.service.LoginService;
import com.spring.demo.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class LoginController {

	@Autowired
	private LoginService ls;

	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	private String loginForm() {
		log.info("conflict 생성중!");
		return "thymeleaf/login/login";
	}

	@PostMapping("/login")
	@ResponseBody
	public Map<String, Boolean> login(@RequestParam String memid, @RequestParam String pwd) {
		MemberVO mem = new MemberVO();
		mem.setMemid(memid);
		mem.setPwd(pwd);
		Map<String, Boolean> map = new HashMap<>();
		if (ls.login(mem)) {
			session.setAttribute("memid", memid);
			map.put("login", true);
		} else
			map.put("login", false);
		return map;
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "thymeleaf/login/login";
	}
}
