package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.BoardDTO;
import poly.dto.UserDTO;
import poly.dto.myOrderDTO;
import poly.service.IMyOrderService;
import poly.service.impl.myOrderService;
import poly.util.CmmUtil;

@Controller
public class myOrderController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "myOrderService")
	IMyOrderService myOrderService;

	@RequestMapping(value = "myOrderIndex")
	public String myOrderIndex(ModelMap model) {
		log.info("myOrderIndex 시작");

		log.info("myOrderIndex 종료");
		return "/myOrderIndex";
	}

	@RequestMapping(value = "myOrder/myOrderLogin")
	public String myOrderLogin() {

		log.info("myOrder/myOrderLogin 시작");
		log.info("myOrder/myOrderLogin 종료");

		return "/myOrder/myOrderLogin";
	}

	@RequestMapping(value = "myOrder/myOrderLoginProc")
	public String myOrderLoginProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {

		log.info("myOrder/myOrderLoginProc 시작");
		String id = CmmUtil.nvl(request.getParameter("id"));
		String pwd = CmmUtil.nvl(request.getParameter("pwd"));

		log.info("id :" + id);
		log.info("pwd :" + pwd);

		myOrderDTO mDTO = new myOrderDTO();

		mDTO.setUser_id(id);
		mDTO.setUser_pwd(pwd);

		mDTO = myOrderService.getUSerInfo(mDTO);
		log.info("uDTO lull? : " + (mDTO == null));

		String msg = "";
		String url = "";
		if (mDTO == null) {
			msg = "로그인 실패";
		} else {
			log.info("mDTO.User_id : " + mDTO.getUser_id());
			log.info("mDTO.User_name : " + mDTO.getUser_name());
			msg = "로그인 성공";
			session.setAttribute("user_id", mDTO.getUser_id());
			session.setAttribute("user_name", mDTO.getUser_name());
		}

		url = "/myOrderIndex.do";

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info("user/userLoginProc 종료");

		return "/redirect";
	}

	@RequestMapping(value = "myOrder/myOrderLogout")
	public String myOrderLogout(HttpSession session, Model model) throws Exception {

		log.info("/myOrder/myOrderLogout 시작");

		String msg = "";
		String url = "";

		msg = "로그아웃 성공";

		url = "/myOrderIndex.do";
		session.invalidate();

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info("/myOrder/myOrderLogout 종료");

		return "/redirect";
	}

	@RequestMapping(value = "myOrder/myOrderList")
	public String myOrderList(ModelMap model) {
		log.info("myOrderList 시작");

		List<myOrderDTO> rList = myOrderService.getMyOrderList();
		log.info("rList : " + rList);
		if (rList == null) {
			rList = new ArrayList<>();
		}
		model.addAttribute("rList", rList);
		log.info("model : " + model);

		log.info("myOrderList 종료");
		return "/myOrder/myOrderList";
	}
	
	@RequestMapping(value = "myOrder/myOrderSignUp")
	public String myOrderSignUp () {
		log.info("/myOrder/myOrderSignUp 시작");
		
		
		
		
		
		log.info("/myOrder/myOrderSignUp 종료");
		return "/myOrder/myOrderSignUp";
	}
	
	@RequestMapping(value = "/myOrder/myOrderSignUpProc")
	public String myOrderSignUpProc(HttpServletRequest request, ModelMap model) {
		
		log.info("/myOrder/myOrderSignUpProc 시작");
		
		log.info("request.getParameter 시작");
		String user_name = request.getParameter("name");
		String user_id = request.getParameter("id");
		String user_pwd = request.getParameter("pwd");
		log.info("request.getParameter 종료");
		log.info("user_name : " + user_name);
		log.info("user_id : " + user_id);
		log.info("user_pwd : " + user_pwd);
		
		myOrderDTO mDTO = new myOrderDTO();
		log.info("mDTO.set 시작");
		mDTO.setUser_id(user_id);
		mDTO.setUser_pwd(user_pwd);
		mDTO.setUser_name(user_name);
		log.info("mDTO.set 종료");
		
		log.info("myOrderService.userSignUp 시작");
		int res = myOrderService.userSignUp(mDTO);
		log.info("myOrderService.userSignUp 종료");
		log.info("res : " + res);
		
		String msg;
		String url = "/myOrder/myOrderLogin.do";
		
		if(res>0) {
			msg = "회원가입을 성공했습니다.";
		} else {
			msg = "회원가입에 실패했습니다.";
		}
		
		log.info("model.addAttribute 시작");
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		log.info("model.addAttribute 종료");
		
		log.info("/myOrder/myOrderSignUpProc 종료");
		
		return "/redirect";
	}
	
	
	
	
	
	
}
