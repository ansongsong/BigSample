package simple.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import simple.base.pojo.po.Sysuser;
import simple.base.service.UserService;

@Controller
@RequestMapping("/hello")
public class FirstAction {

	@Autowired
	private UserService userService;
	//首页
	@RequestMapping(method=RequestMethod.GET,value = "/first")
	public String first(Model model){
		Sysuser sysuser = userService.findSysuserById("189");
		model.addAttribute("sysuser", sysuser);
		return "/base/first";//逻辑视图名
	}
	@RequestMapping(method=RequestMethod.GET,value = "/welcome")
	public String welcome(Model model){
		return "/base/welcome";//逻辑视图名
	}
}
