package com.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.mapper.LoginMapper;
import com.spring.demo.vo.MemberVO;

@Service
public class LoginService {

	@Autowired
	private LoginMapper lm;

	public boolean login(MemberVO mem) {
		return lm.login(mem) > 0;
	}
}
