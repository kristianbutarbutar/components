package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.dao.core.BaseListsDAO;
import tao.vo.BListVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListCtrl {
	private static final Logger logger = Logger.getLogger(ListCtrl.class);
	
	@RequestMapping(value="/ui/sys/list/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BListVO getLists(@PathVariable String name) {
		return (new BaseListsDAO()).getLists(name);
	}
	
	@RequestMapping(value="/ui/sys/list/add", method = RequestMethod.POST)
	public String addList(@RequestBody BListVO vo) {
		(new BaseListsDAO()).addList(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/list/update", method = RequestMethod.POST)
	public String updateList(@RequestBody BListVO vo) {
		(new BaseListsDAO()).updateList(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/list/drop", method = RequestMethod.POST)
	public String deleteList(@RequestBody BListVO vo) {
		(new BaseListsDAO()).deleteList(vo);  
        return "success";
	}
	
}
