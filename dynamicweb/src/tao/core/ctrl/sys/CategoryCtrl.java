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

import tao.dao.core.BaseCategoryDAO;
import tao.vo.BCategoryVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryCtrl {
	private static final Logger logger = Logger.getLogger(CategoryCtrl.class);
	
	@RequestMapping(value="/ui/sys/category/{name}/{code}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BCategoryVO getCategorys(@PathVariable String name, @PathVariable String code) {
		String n="null", l="null";
		if(!name.equalsIgnoreCase("-")) n = name;
		if(!code.equalsIgnoreCase("-")) l = code;
		return (new BaseCategoryDAO()).getCategories(n, l);
	}
	
	@RequestMapping(value="/ui/sys/category/add", method = RequestMethod.POST, consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody ResponseEntity  addCategory(@RequestBody BCategoryVO vo) {
		(new BaseCategoryDAO()).addCategory(vo);  
        return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value="/ui/sys/category/update", method = RequestMethod.POST, consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody ResponseEntity  updateCategory(@RequestBody BCategoryVO vo) {
		vo.setUpdatedBy("SYS");
		vo.setCreatedBy("SYS");
		if(vo.getCid()!=null && !vo.getCid().equals(""))
			(new BaseCategoryDAO()).updateCategory(vo);
		else addCategory(vo);
        return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value="/ui/sys/category/drop", method = RequestMethod.POST, consumes =
		 {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
		 produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody ResponseEntity  deleteCategory(@RequestBody BCategoryVO vo) {
		(new BaseCategoryDAO()).deleteCategory(vo);  
        return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
