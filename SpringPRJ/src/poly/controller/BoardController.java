package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.BoardDTO;
import poly.service.IBoardService;
import poly.util.CmmUtil;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "BoardService")
	IBoardService BoardService;
	
	
	@RequestMapping(value="board/boardList")
	public String managerList(ModelMap model){
		
		List <BoardDTO> rList = BoardService.getBoardList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList", rList);

		log.info("board/boardList 시작");
		
		return "/board/boardList";
	}
	@RequestMapping(value="board/newPost")
	public String newPost(){
		

		log.info("board/newPost 시작");
		
		return "/board/newPost";
	}
	
	@RequestMapping(value="board/doPost")
	public String doPost(HttpServletRequest request, ModelMap model){
		
		
		String reg_id = "woodo";
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		log.info("post_title : " + post_title);
		log.info("post_content : " + post_content);
		BoardDTO pDTO = new BoardDTO();
		
		pDTO.setReg_id(reg_id);
		pDTO.setPost_title(post_title);
		pDTO.setPost_content(post_content);

		log.info("board/doPost 시작");
		
		int res = BoardService.insertPost(pDTO);
		
		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "등록이 성공했습니다.";
		} else {
			msg = "등록에 실패했습니다.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		
		return "/redirect";
	}
	
	@RequestMapping(value="board/boardDetail")
	public String boardDetail(HttpServletRequest request, ModelMap model){
		
		
		String post_no = request.getParameter("no");
		
		BoardDTO pDTO = new BoardDTO();
		pDTO.setPost_no(post_no);
		
		BoardDTO rDTO =BoardService.getBoardDetail(pDTO);
		
		if(rDTO == null) {
			model.addAttribute("msg", "존재하지 않는 게시물입니다.");
			model.addAttribute("url", "/board/boardList.do");
			return "/redirect";
		}
		model.addAttribute("rDTO", rDTO);

		log.info("/board/boardDtail 시작");
		log.info("title : " + rDTO.getPost_title());
		log.info("content : " + rDTO.getPost_content());
		
		return "/board/boardDetail";
	}
	
	@RequestMapping(value="board/editPost")
	public String editPost(HttpServletRequest request, ModelMap model){
		
		BoardDTO pDTO = new BoardDTO();
		
		String post_no = request.getParameter("no");
		pDTO.setPost_no(post_no);
		
		BoardDTO rDTO =BoardService.getBoardDetail(pDTO);
		
		if(rDTO == null) {
			model.addAttribute("msg", "존재하지 않는 게시물입니다.");
			model.addAttribute("url", "/board/boardList.do");
			return "/redirect";
		}
		model.addAttribute("rDTO", rDTO);

		log.info("board/editPost 시작");
		
		return "/board/editPost";
	}
	
	@RequestMapping(value="board/doEditPost")
	public String doEditPost(HttpServletRequest request, ModelMap model){
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_no = request.getParameter("post_no");
		log.info(post_title);
		log.info(post_content);
		log.info(post_no);
		
		
		BoardDTO pDTO = new BoardDTO();
		
		pDTO.setPost_title(post_title);
		pDTO.setPost_content(post_content);
		pDTO.setPost_no(post_no);
		
		log.info("board/editPost 시작");
		
		int res = BoardService.updatePost(pDTO);
		
		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "편집을 성공했습니다.";
		} else {
			msg = "편집을 실패했습니다.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/redirect";
	}
	
	@RequestMapping(value="board/deletePost")
	public String deletePost(HttpServletRequest request, ModelMap model){
		
		
		String post_no = request.getParameter("no");
		
		BoardDTO pDTO = new BoardDTO();
		pDTO.setPost_no(post_no);
		
		log.info("/board/deletePost 시작");
		
		int res = BoardService.deletePost(pDTO);
		
		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "삭제를 성공했습니다.";
		} else {
			msg = "삭제를 실패했습니다.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/redirect";
	}
	
	@RequestMapping(value="board/searchList")
	public @ResponseBody List<BoardDTO> searchList(HttpServletRequest request) throws Exception{
		log.info("board/searchList start!!");
		
		String post_title = CmmUtil.nvl(request.getParameter("post_title"));
		log.info("post_title : " + post_title);
		
		BoardDTO bDTO = new BoardDTO();
		bDTO.setPost_title(post_title);
		
		List<BoardDTO> bList = BoardService.getSearchList(bDTO);
		log.info("bList size : " + bList.size());
		
		log.info("board/searchList end!!");
		return bList;
	}
}
