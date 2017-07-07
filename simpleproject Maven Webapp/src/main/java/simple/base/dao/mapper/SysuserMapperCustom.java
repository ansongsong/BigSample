package simple.base.dao.mapper;

import java.util.List;

import simple.base.pojo.vo.SysuserCustom;
import simple.base.pojo.vo.SysuserQueryVo;

public interface SysuserMapperCustom {

//	查询用户列表
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
}
