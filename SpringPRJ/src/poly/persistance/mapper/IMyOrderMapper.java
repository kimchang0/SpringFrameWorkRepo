package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.myOrderDTO;

@Mapper("myOrderMapper")
public interface IMyOrderMapper {
	
	List<myOrderDTO> getMyOrderList(myOrderDTO mDTO);

	myOrderDTO getUserInfo(myOrderDTO mDTO);

	int userSignUp(myOrderDTO mDTO);

}
