package IntellectRequirment.Intellect.dao;

import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

import IntellectRequirment.Intellect.data.FinalStoreData;
import IntellectRequirment.Intellect.vo.DataRequestVo;

/**
 * Ahan Ram
 *
 */
@RestController
public class IntellectRestDaoImpl implements IntellectRestDao {
	public void createNewUser(DataRequestVo dataVo) throws Exception {
		if (null != FinalStoreData.finalData.get(dataVo.getEmail()))
			throw new Exception("Email or User already present");
		dataVo.setIsActive(true);
		dataVo.setId(dataVo.getfName() + new Random().nextInt());
		FinalStoreData.finalData.put(dataVo.getEmail(), dataVo);

	}

	public void updateNewUser(DataRequestVo dataVo) throws Exception {
		if (null == FinalStoreData.finalData.get(dataVo.getEmail()))
			throw new Exception("User not prsent");
		DataRequestVo dataRequestVo = FinalStoreData.finalData.get(dataVo.getEmail());
		if (null != dataVo.getBrithDate())
			dataRequestVo.setBrithDate(dataVo.getBrithDate());
		if (null != dataVo.getPincode())
			dataRequestVo.setPincode(dataVo.getPincode());

	}

	public void deleteUser(String email) throws Exception {
		if (null == FinalStoreData.finalData.get(email))
			throw new Exception("User not prsent");
		FinalStoreData.finalData.get(email).setIsActive(false);
		;

	}

}
