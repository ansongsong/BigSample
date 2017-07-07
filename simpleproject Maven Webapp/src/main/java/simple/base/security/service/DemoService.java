package simple.base.security.service;

import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

import simple.base.security.bean.User;

public interface DemoService {
//	在@RolesAllowed中设置了ROLE_ADMIN和ROLE_USER两个权限，只要当前用户拥有其中任意一个权限都可以调用这个方法。
	@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
	List<User> findByName(String name);
	
//	在@Secured中设置了ROLE_ADMIN和ROLE_USER两个权限，只要当前用户拥有其中任意一个权限都可以调用这个方法。
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	List<User> findByName2(String name);
	
//	DenyAll拒绝所有的用户调用方法。
	@DenyAll
	public String userMessage1();

//	PermitAll允许所有的用户调用方法
	@PermitAll
	public String userMessage2();
}
