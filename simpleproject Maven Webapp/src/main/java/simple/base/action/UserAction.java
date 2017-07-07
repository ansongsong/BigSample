package simple.base.action;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import simple.base.pojo.vo.SysuserCustom;
import simple.base.pojo.vo.SysuserQueryVo;
import simple.base.process.result.DataGridResultInfo;
import simple.base.service.UserService;
/**
 * 
 * @author company
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	//用户查询页面
	@RequestMapping("queryUser")
	public String queryUser(Model model){

		//将页面所需要的数据去除，传到页面
		return "queryUser";
	}
//	/user/queryUser_result
	//用户查询页面的结果集
	//最终DataGridResultInfo通过@ResponseBody将Java对象转成json
	@RequestMapping("queryUser_result")
	public @ResponseBody DataGridResultInfo queryUser_result(SysuserQueryVo sysuserQueryVo) throws Exception{
		
		List<SysuserCustom> rows = userService.findSysuserList(sysuserQueryVo);
		
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		//填充total
		//填充rows
		
		
		return dataGridResultInfo;
	}
}
