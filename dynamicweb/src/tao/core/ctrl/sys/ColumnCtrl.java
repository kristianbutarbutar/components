package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.dao.core.BaseColumnsDAO;
import tao.vo.BColumnVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColumnCtrl {
	private static final Logger logger = Logger.getLogger(ColumnCtrl.class);
	
	@RequestMapping(value="/ui/sys/column/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BColumnVO getLists(@PathVariable String name) {
		return (new BaseColumnsDAO()).getColumns(name);
	}
	
	@RequestMapping(value="/ui/sys/column/add", method = RequestMethod.POST)
	public String addList(@RequestBody BColumnVO vo) {
		(new BaseColumnsDAO()).addColumn(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/column/update", method = RequestMethod.POST)
	public String updateList(@RequestBody BColumnVO vo) {
		(new BaseColumnsDAO()).updateColumn(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/column/drop", method = RequestMethod.POST)
	public String deleteList(@RequestBody BColumnVO vo) {
		(new BaseColumnsDAO()).deleteColumn(vo);  
        return "success";
	}
	
}
