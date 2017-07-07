package simple.base.pojo.vo;

import simple.base.pojo.po.Sysuser;
/**
 * 通常自定义扩展类继承查询列较多的那个po类
 * @author company
 *
 */
public class SysuserCustom extends Sysuser{

	//单位名称
	private String sysmc;

	public String getSysmc() {
		return sysmc;
	}

	public void setSysmc(String sysmc) {
		this.sysmc = sysmc;
	}
	
}
