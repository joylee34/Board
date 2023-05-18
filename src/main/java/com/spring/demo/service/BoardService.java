package com.spring.demo.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.mapper.BoardMapper;
import com.spring.demo.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper dao;

	public List<BoardVO> listBoard2() {
		return dao.listBoard();
	}

	public BoardVO getBoard(int bnum) {
		return dao.getBoard(bnum);
	}

	public boolean addBoard(BoardVO board) {
		return dao.addBoard(board) > 0;
	}

	public boolean updateBoard(BoardVO board) {
		return dao.updateBoard(board) > 0;
	}

	public boolean deleteBoard(int bnum) {
		return dao.deleteBoard(bnum) > 0;
	}

	public JSONArray listBoard() {
		List<BoardVO> blist = dao.listBoard();
		JSONArray jsArr = new JSONArray();
		for (BoardVO b : blist) {
			jsArr.add(convertBoardVOToJson(b));
		}
		return jsArr;
	}

	public JSONObject convertBoardVOToJson(BoardVO b) {

		JSONObject json = new JSONObject();

		json.put("bnum", b.getBnum());
		json.put("btitle", b.getBtitle());
		json.put("bauthor", b.getBauthor());
		json.put("btime", b.getBtime());

		return json;
	}
}
