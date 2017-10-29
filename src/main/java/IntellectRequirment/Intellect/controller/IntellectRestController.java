package IntellectRequirment.Intellect.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import IntellectRequirment.Intellect.dao.IntellectRestDao;
import IntellectRequirment.Intellect.vo.DataRequestVo;
import IntellectRequirment.Intellect.vo.DataResponseVo;

/**
 * Ahan Ram
 *
 */
@RestController
public class IntellectRestController {

	@Autowired
	private IntellectRestDao intellectRestDao;

	@RequestMapping(value = "Create", method = RequestMethod.POST)
	public ResponseEntity<Object> createNewUser(@RequestBody DataRequestVo dataVo) {
		System.out.println("inside createNewUser-------------");
		DataResponseVo responseVo = new DataResponseVo();
		try {
			if (null == dataVo.getiName())
				throw new Exception("Fill all mandatory Flieds <IName>");
			else if (null == dataVo.getfName())
				throw new Exception("Fill all mandatory Flieds <Fname>");
			else if (null == dataVo.getEmail())
				throw new Exception("Fill all mandatory Flieds <Email>");
			else if (null == dataVo.getBrithDate())
				throw new Exception("Fill all mandatory Flieds <date of brith>");

			SimpleDateFormat txt = new SimpleDateFormat("dd-MMM-YYYY");
			Date dateOfBrith = txt.parse(dataVo.getBrithDate());

			if (dateOfBrith.after(Calendar.getInstance().getTime()))
				throw new Exception("Date Should not be in future");
			intellectRestDao.createNewUser(dataVo);
			responseVo.setRestMsg("Successfully inserted ! " + dataVo.getEmail());
			responseVo.setUserId(dataVo.getId());

		} catch (Exception e) {
			responseVo.setRestMsg("Failed");
			responseVo.setUserId(dataVo.getId());
			responseVo.setValErrors(e.getMessage());
		}
		return new ResponseEntity<Object>(responseVo, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "Update", method = RequestMethod.POST)
	public ResponseEntity<Object> updateNewUser(@RequestBody DataRequestVo dataVo) {
		System.out.println("inside updateNewUser-------------");
		DataResponseVo responseVo = new DataResponseVo();
		try {
			if (null == dataVo.getId())
				throw new Exception("Fill all mandatory Flieds <userId or Id>");
			else if (null == dataVo.getBrithDate() && null == dataVo.getPincode())
				throw new Exception("Fill all mandatory Flieds <date of brith> or <Pincode>");

			SimpleDateFormat txt = new SimpleDateFormat("dd-MMM-YYYY");
			Date dateOfBrith = txt.parse(dataVo.getBrithDate());

			if (dateOfBrith.after(Calendar.getInstance().getTime()))
				throw new Exception("Date Should not be in future");
			intellectRestDao.updateNewUser(dataVo);
			responseVo.setRestMsg("Successfully Update ! " + dataVo.getEmail());

		} catch (Exception e) {
			responseVo.setRestMsg("Failed");
			responseVo.setUserId(dataVo.getId());
			responseVo.setValErrors(e.getMessage());
		}
		return new ResponseEntity<Object>(responseVo, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "delete")
	public ResponseEntity<Object> deleteUser(@RequestParam String emailId) {
		System.out.println("inside updateNewUser-------------");
		DataResponseVo responseVo = new DataResponseVo();
		try {

			intellectRestDao.deleteUser(emailId);
			responseVo.setRestMsg("Successfully delete ! " + emailId);

		} catch (Exception e) {
			responseVo.setRestMsg("Failed");
			responseVo.setUserId(emailId);
			responseVo.setValErrors(e.getMessage());
		}
		return new ResponseEntity<Object>(responseVo, HttpStatus.ACCEPTED);
	}

}
