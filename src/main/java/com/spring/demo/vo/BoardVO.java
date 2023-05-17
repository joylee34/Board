package com.spring.demo.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // 모든 변수의 setters/getters
@ToString
@EqualsAndHashCode(exclude = { "btitle", "bauthor", "btime", "btext" })
@AllArgsConstructor // 멤버 변수 다 넣은 생성자 생성해주세요.
@NoArgsConstructor // 기본 생성자 생성해주세요.
public class BoardVO {
	private int bnum;
	private String btitle;
	private Timestamp btime;
	private String bauthor;
	private String btext;

	public BoardVO(int bnum, String btitle, String btext) {
		setBnum(bnum);
		setBtitle(btitle);
		setBtext(btext);
	}
}
