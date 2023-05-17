package com.spring.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // 모든 변수의 setters/getters
@ToString
@EqualsAndHashCode(exclude = { "pwd" })
@AllArgsConstructor // 멤버 변수 다 넣은 생성자 생성해주세요.
@NoArgsConstructor // 기본 생성자 생성해주세요.
public class MemberVO {

	private String memid;
	private String pwd;
}
