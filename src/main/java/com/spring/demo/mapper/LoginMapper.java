package com.spring.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.demo.vo.MemberVO;

@Mapper
public interface LoginMapper {

	public int login(MemberVO mem);
}
