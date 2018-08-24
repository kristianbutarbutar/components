package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
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
	
	@RequestMapping(value="/ui/sys/category/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BCategoryVO getForms(@PathVariable String name) {
		return (new BaseCategoryDAO()).getCategories(name);
	}
	
	@RequestMapping(value="/ui/sys/category/add", method = RequestMethod.POST)
	public String addForm(@RequestBody BCategoryVO vo) {
		(new BaseCategoryDAO()).addCategory(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/category/update", method = RequestMethod.POST)
	public String updateForm(@RequestBody BCategoryVO vo) {
		(new BaseCategoryDAO()).updateCategory(vo);  
        return "success";
	}
	
	@RequestMapping(value="/ui/sys/category/drop", method = RequestMethod.POST)
	public String deleteForm(@RequestBody BCategoryVO vo) {
		(new BaseCategoryDAO()).deleteCategory(vo);  
        return "success";
	}
	
}
