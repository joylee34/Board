package com.spring.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.demo.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> listBoard();

	public BoardVO getBoard(int bnum);

	public int addBoard(BoardVO board);

	public int updateBoard(BoardVO board);

	public int deleteBoard(int bnum);
}
