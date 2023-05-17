package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.mapper.BoardMapper;
import com.spring.demo.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper dao;

	public List<BoardVO> listBoard() {
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
}
