package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.EmpDTO;
import poly.service.IEmpService;

@Controller
public class EmpController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EmpService")
	IEmpService empService;
	
	@RequestMapping(value="emp/empList")
	public String empList(ModelMap model){
		
		List <EmpDTO> rList = empService.getEmpList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList", rList);

		for(EmpDTO e : rList) {
			log.info("ename" + e.getEname());
			log.info("empno" + e.getEmpno());
			
		}
		log.info("emp/empList 시작");
		return "/emp/empList";
	}
	
	@RequestMapping(value="emp/managerList")
	public String managerList(ModelMap model){
		
		List <EmpDTO> rList = empService.getManagerList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList", rList);

		for(EmpDTO e : rList) {
			log.info("ename" + e.getEname());
			log.info("empno" + e.getEmpno());
			
		}
		log.info("emp/empList 시작");
		return "/emp/empList";
	}

	
}
