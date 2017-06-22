package simple.base.dao.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import simple.base.pojo.po.Sysuser;
import junit.framework.TestCase;

public class SysuserCustomMapperTest extends TestCase {

	private ApplicationContext applicationContext;
	@Override
	protected void setUp() throws Exception {
		//获得spring容器
		applicationContext = new ClassPathXmlApplicationContext(new String[]{
			"spring/applicationContext.xml",
			"spring/applicationContext-base-dao.xml"
		});
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
	}
	
	public void testFindSysuserById() throws Exception{
		SysuserCustomMapper sysuserCustomMapper = (SysuserCustomMapper) applicationContext.getBean("sysuserCustomMapper");
		Sysuser findSysuserById = sysuserCustomMapper.findSysuserById("286");
		System.out.println(findSysuserById.toString());
	}

}
