package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.util.CmmUtil;

@Controller
public class userController {

	Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "UserService")
	IUserService UserService;
	
	@RequestMapping(value="user/userLogin")
	public String userLogin(){

		log.info("board/boardList 시작");
		log.info("board/boardList 종료");
		
		return "/user/userLogin";
	}
	
	@RequestMapping(value="user/userLoginProc")
	public String userLoginProc(HttpServletRequest request, Model model, HttpSession session) throws Exception{

		log.info("board/boardList 시작");
		String id = CmmUtil.nvl(request.getParameter("id")); 
		String pwd = CmmUtil.nvl(request.getParameter("pwd")); 
		
		log.info("id :" + id);
		log.info("pwd :" + pwd);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUser_id(id);
		uDTO.setUser_pwd(pwd);
		
		uDTO = UserService.getUSerInfo(uDTO);
		log.info("uDTO lull? : " + (uDTO == null));
		
		String msg = "";
		String url = "";
		if( uDTO == null) {
			msg = "로그인 실패";
		} else {
			log.info("uDTO.User_id : " + uDTO.getUser_id());
			log.info("uDTO.User_pwd : " + uDTO.getUser_name());
			msg = "로그인 성공";
			session.setAttribute("user_seq", uDTO.getUser_seq());
			session.setAttribute("user_name", uDTO.getUser_name());
		}
		
		url = "/";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		
		
		
		log.info("board/boardList 종료");
		
		return "/alert";
	}
}
