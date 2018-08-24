package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tao.dao.core.BaseFormColumnsDAO;
import tao.vo.BColumnVO;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormColumnCtrl {
	private static final Logger logger = Logger.getLogger(FormColumnCtrl.class);
	
	@RequestMapping(value="/ui/sys/formcolumns/{formid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BColumnVO getForms(@PathVariable String formid) {
		return (new BaseFormColumnsDAO()).getFormColumns(formid);
	}
	
	@RequestMapping(value="/ui/sys/formcolumns/{formid}/{colid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String unlinkFormColumn(@PathVariable String formid, @PathVariable String colid) {
		return (new BaseFormColumnsDAO()).deleteFormColumns(formid, colid);
	}
}
