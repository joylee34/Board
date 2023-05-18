package com.spring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class HttpSessionHandler implements HttpSessionListener {

	public static Map<String, HttpSession> map = new HashMap<>();

	public void sessionCreated(HttpSessionEvent se) {
		log.info("핸들러 돌아감??");
		HttpSession s = se.getSession(); // 생성된 세션을 가지고 옴
		map.put(s.getId(), s);
		log.info("핸들러제발돌아가라:" + map.toString());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession s = se.getSession();
		map.remove(s.getId());
	}
}
