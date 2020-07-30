package poly.service;

import java.util.List;

import poly.dto.myOrderDTO;

public interface IMyOrderService {

	List<myOrderDTO> getMyOrderList(myOrderDTO mDTO);

	myOrderDTO getUSerInfo(myOrderDTO mDTO);

	int userSignUp(myOrderDTO mDTO);

}
