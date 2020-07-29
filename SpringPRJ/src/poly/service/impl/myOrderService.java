package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.myOrderDTO;
import poly.persistance.mapper.IMyOrderMapper;
import poly.service.IMyOrderService;

@Service("myOrderService")
public class myOrderService implements IMyOrderService{
	
	@Resource(name = "myOrderMapper")
	IMyOrderMapper myOrderMapper;

	@Override
	public List<myOrderDTO> getMyOrderList(myOrderDTO mDTO) {

		return myOrderMapper.getMyOrderList(mDTO);
	}

	@Override
	public myOrderDTO getUSerInfo(myOrderDTO mDTO) {

		return myOrderMapper.getUserInfo(mDTO);
	}

	@Override
	public int userSignUp(myOrderDTO mDTO) {

		return myOrderMapper.userSignUp(mDTO);
	}






}
