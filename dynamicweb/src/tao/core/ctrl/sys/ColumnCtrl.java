package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/ui/sys/column/{name}/{label}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BColumnVO getColumns(@PathVariable String name, @PathVariable String label) {
		String n="null", l="null";
		if(!name.equalsIgnoreCase("-")) n = name;
		if(!label.equalsIgnoreCase("-")) l = label;
		return (new BaseColumnsDAO()).getColumns(n,l);
	}
	
	@RequestMapping(value="/ui/sys/column/add", method = RequestMethod.POST, consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity addColumn(@RequestBody BColumnVO vo) {
		(new BaseColumnsDAO()).addColumn(vo);  
         return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value="/ui/sys/column/update", method = RequestMethod.POST, consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity updateColumn(@RequestBody BColumnVO vo) {
		vo.setUpdatedBy("SYS");
		vo.setCreatedBy("SYS");
		if(vo.getCid()!=null && !vo.getCid().equals(""))
			(new BaseColumnsDAO()).updateColumn(vo);
		else addColumn(vo);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(value="/ui/sys/column/drop", method = RequestMethod.POST,consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity deleteColumn(@RequestBody BColumnVO vo) {
		(new BaseColumnsDAO()).deleteColumn(vo);
		return ResponseEntity.ok("success");
	}
	
}
