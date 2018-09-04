package tao.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageCtrl {
	@RequestMapping(value = "/ui/landing", method = RequestMethod.GET)
	public String showSearchForm(ModelMap model) {
		model.addAttribute("Search record[s]", "search records");
		return "syslanding";
	}
	
	@RequestMapping(value = "/ui/sys/{menu}", method = RequestMethod.GET)
	public String showPage(ModelMap model, @PathVariable String menu) {
		System.out.println("I was triggered" + menu);
		return "/sys/" + menu.trim().toLowerCase();
	}
}
