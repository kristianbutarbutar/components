package tao.core.ctrl.sys;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryCtrl {
	private static final Logger logger = Logger.getLogger(CategoryCtrl.class);
}
