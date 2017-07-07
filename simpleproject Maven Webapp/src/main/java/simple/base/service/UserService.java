package simple.base.service;

import java.util.List;

import simple.base.pojo.po.Sysuser;
import simple.base.pojo.vo.SysuserCustom;
import simple.base.pojo.vo.SysuserQueryVo;

public interface UserService {

	//根据用户id查询用户信息
	public Sysuser findSysuserById(String id);
	
	//根据条件查询用户信息
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
}
