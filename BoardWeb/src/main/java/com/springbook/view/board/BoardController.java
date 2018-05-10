package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;


@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do") // value 속성은 생략 가능, 특별한 경우가 아니면 대부분 생략
	public String insertBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 등록 처리");
	
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("글 수정 처리");
		System.out.println("작성자 이름: " + vo.getWriter());
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	// 글 목록 조희
	@RequestMapping("/getBoardList.do")
	public String getBoardList( @RequestParam(value="seachCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="seachKeyword", defaultValue="", required=false) String searchKeyword,
			BoardVO vo, Model model) {
		
		System.out.println("글 목록 조희 처리");
		System.out.println("검색 조건: " + condition);
		System.out.println("검색 단어: " + searchKeyword);
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONCTENT");
		return conditionMap;
	}
	
}
