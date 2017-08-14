package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.AdminType;
import com.yc.biz.AccessTokenBiz;
import com.yc.biz.AdminTypeBiz;


/**
 * 当servlet容器一启动就会加载这个类
 *
 */
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;

    public InitListener() {

    }
    public void contextInitialized2(ServletContextEvent sce)  { 
    	//取application
    	ServletContext application = sce.getServletContext();
    	ac = WebApplicationContextUtils.getWebApplicationContext(application);
    	//获取管理员的所有类别，存到application中的adminTypeList
    	AdminTypeBiz typeBiz = (AdminTypeBiz) ac.getBean("adminTypeBizImpl");
    	List<AdminType> adminTypeList = typeBiz.getTypeList();
    	application.setAttribute("adminTypeList", adminTypeList);
    }


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 取application
		ServletContext application = sce.getServletContext();
		// 工具类: tomcat启动时-> ContextLoaderListener -> 读取 contextConfigLocation指定的
		// beans.xml -> 加载整个应用程序中的bean ioc, -> di -> context -> 存到application
		// 利用spring提代的 WebApplicationContextUtils类来获取 spring 容器
		ac = WebApplicationContextUtils.getWebApplicationContext(application);
		AccessTokenBiz atb=(AccessTokenBiz) ac.getBean("accessTokenBizImpl");
		try {
			atb.updateAccessToken();
		} catch (Exception e) {
			System.out.println("AccessToken更新失败!");
			e.printStackTrace();
		}
	}
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }
	
}
