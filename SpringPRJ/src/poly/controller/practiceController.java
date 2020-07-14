package poly.controller;

import static poly.util.CmmUtil.nvl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class practiceController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="table")
	public String table() {
		log.info("table 시작");
		
		return "/table";
	}
	
	@RequestMapping(value="get")
	public String get(HttpServletRequest request, ModelMap model) throws Exception{
		
		String name = nvl(request.getParameter("name"));
		log.info("get 시작");
		log.info("name: " +  name);
		nvl("1234");
		model.addAttribute("name", name);
		
		return "/get";
	}
	
	@RequestMapping(value="form")
	public String form(){
		
		log.info("form 시작");
		
		return "/form";
	}
	
	@RequestMapping(value="dopost", method = RequestMethod.POST)
	public String dopost(HttpServletRequest request, ModelMap model) throws Exception{
		
		String name = nvl(request.getParameter("name"));
		log.info("get 시작");
		log.info("name: " +  name);
		model.addAttribute("name", name);
		
		return "/get";
	}
	
}
