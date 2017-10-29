package IntellectRequirment.Intellect.dao;

import org.springframework.stereotype.Service;

import IntellectRequirment.Intellect.vo.DataRequestVo;

/**
 * Ahan Ram
 *
 */
@Service
public interface IntellectRestDao {

	public void createNewUser( DataRequestVo dataVo) throws Exception;
	public void updateNewUser( DataRequestVo dataVo) throws Exception;
	public void deleteUser(String emailId) throws Exception;

}
