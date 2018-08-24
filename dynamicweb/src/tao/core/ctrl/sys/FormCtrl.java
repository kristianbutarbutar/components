package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.dao.core.BaseFormsDAO;
import tao.vo.BFormVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormCtrl {
	private static final Logger logger = Logger.getLogger(FormCtrl.class);
	
	@RequestMapping(value="/ui/sys/form/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BFormVO getForms(@PathVariable String name) {
		return (new BaseFormsDAO()).getForms(name);
	}
	
	@RequestMapping(value="/ui/sys/form/add", method = RequestMethod.POST)
	public String addForm(@RequestBody BFormVO vo) {
		(new BaseFormsDAO()).addForm(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/form/update", method = RequestMethod.POST)
	public String updateForm(@RequestBody BFormVO vo) {
		(new BaseFormsDAO()).updateForm(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/form/drop", method = RequestMethod.POST)
	public String deleteForm(@RequestBody BFormVO vo) {
		(new BaseFormsDAO()).deleteForm(vo);  
        return "success";
	}
	
}
