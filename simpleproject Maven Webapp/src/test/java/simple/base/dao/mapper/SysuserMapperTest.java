package simple.base.dao.mapper;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bigsimple.utils.UUIDBuild;
import simple.base.pojo.po.Sysuser;
import simple.base.pojo.po.SysuserExample;
import simple.base.pojo.po.SysuserExample.Criteria;
import junit.framework.TestCase;

public class SysuserMapperTest extends TestCase {

	private ApplicationContext applicationContext;
	SysuserMapper sysuserMapper;
	@Override
	protected void setUp() throws Exception {
		//获得spring容器
		applicationContext = new ClassPathXmlApplicationContext(new String[]{
			"spring/applicationContext.xml",
			"spring/applicationContext-base-dao.xml"
		});
		sysuserMapper = (SysuserMapper) applicationContext.getBean("sysuserMapper");
	}
	
	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
	}
	
	/**
	 * 添加
	 */
	public void testInsert(){
		Sysuser sysuser = new Sysuser();
		sysuser.setId(UUIDBuild.getUUID());
		sysuser.setUsername("aa");
		sysuser.setUserid("11");
		sysuserMapper.insert(sysuser);
	}
	/**
	 * 删除
	 */
	public void delete(){
		sysuserMapper.deleteByPrimaryKey("test009");
	}
	/**
	 * 只更新sysuser中属性不为空的属性
	 */
	public void testUpdateByPrimaryKeySelective(){
		Sysuser sysuser = new Sysuser();
		sysuser.setId(UUIDBuild.getUUID());
		sysuser.setUsername("aa");
		sysuser.setUserid("11");
		sysuserMapper.updateByPrimaryKeySelective(sysuser);
	}
	/**
	 * 根据主键更新,不管sysuser中属性是否为空，都更新
	 */
	public void testUpdateByPrimaryKey(){
		Sysuser sysuser = new Sysuser();
		sysuser.setId(UUIDBuild.getUUID());
		sysuser.setUsername("aa");
		sysuser.setUserid("11");
		sysuserMapper.updateByPrimaryKey(sysuser);
	}
	
	/**
	 * 根据id查询
	 * @throws Exception
	 */
	public void testFindSysuserById() throws Exception{
		
		Sysuser findSysuserById = sysuserMapper.selectByPrimaryKey("286");
		System.out.println(findSysuserById.toString());
	}
	
	/**
	 * 自定义查询条件查询
	 */
	public void testSelectByExample(){
		SysuserExample sysuserExample = new SysuserExample();
		Criteria criteria = sysuserExample.createCriteria();
		criteria.andUsernameEqualTo("test009");
		criteria.andGroupidEqualTo("4");
		
		List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);
		System.out.println(list.size());
	}
	
}
