package simple.base.pojo.vo;
/**
 * 包装类，用户页面向action传递参数，将数据传到mybatis
 * 扩展类，查询条件，提交信息
 * @author company
 *
 */
public class SysuserQueryVo {

	private SysuserCustom sysuserCustom;

	public SysuserCustom getSysuserCustom() {
		return sysuserCustom;
	}

	public void setSysuserCustom(SysuserCustom sysuserCustom) {
		this.sysuserCustom = sysuserCustom;
	}
	
}
