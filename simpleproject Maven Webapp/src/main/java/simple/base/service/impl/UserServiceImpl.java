package simple.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import simple.base.dao.mapper.SysuserMapper;
import simple.base.dao.mapper.SysuserMapperCustom;
import simple.base.pojo.po.Sysuser;
import simple.base.pojo.vo.SysuserCustom;
import simple.base.pojo.vo.SysuserQueryVo;
import simple.base.service.UserService;

public class UserServiceImpl implements UserService{

//	注入mapper
	@Autowired
	private SysuserMapper sysuserMapper;
	@Autowired
	private SysuserMapperCustom sysuserMapperCustom;
	
	@Override
	public Sysuser findSysuserById(String id) {
		//调用mapper查询用户信息
		return sysuserMapper.selectByPrimaryKey(id);
		
	}

	@Override
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
	}

}
