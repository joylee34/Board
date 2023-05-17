package com.spring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.demo.service.BoardService;
import com.spring.demo.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	@Autowired
	private BoardService bs;

	@GetMapping("/test")
	private String test() {
		return "thymeleaf/index";
	}

	@GetMapping("/blist2")
	private String listBoard2(Model m) {
		m.addAttribute("list", bs.listBoard2());
		return "thymeleaf/board/boardlist2";
	}

	@GetMapping("/blist")
	private String listBoard(Model m) {
		return "thymeleaf/board/boardlist";
	}

	@GetMapping("/listboard")
	@ResponseBody
	private JSONArray listBoard() {
		log.info(bs.listBoard().toJSONString());
		return bs.listBoard();
	}

	@GetMapping("/bdetail/{bnum}")
	private String getBoard(@PathVariable int bnum, Model m) {
		m.addAttribute("board", bs.getBoard(bnum));
		return "thymeleaf/board/bdetail";
	}

	@GetMapping("/addform")
	private String addForm() {
		return "thymeleaf/board/addform";
	}

	@PostMapping("/add")
	@ResponseBody
	private Map<String, Boolean> addBoard(BoardVO board) {
		Map<String, Boolean> map = new HashMap<>();
		map.put("uploaded", bs.addBoard(board));
		return map;
	}

	@GetMapping("/editform/{bnum}")
	private String editForm(int bnum, Model m) {
		m.addAttribute("board", bs.getBoard(bnum));
		return "thymeleaf/board/editform";
	}

	@PostMapping("/update")
	private boolean updateBoard(BoardVO board) {
		return bs.updateBoard(board);
	}

	@GetMapping("/delete/{bnum}")
	private boolean deleteBoard(int bnum) {
		return bs.deleteBoard(bnum);
	}
}
