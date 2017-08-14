package com.yc.web.controllors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;


@RestController
public class AdminController {
	@Resource(name="adminBizImpl")
	private AdminBiz adminBiz;
	
	/**
	 * 管理员登录
	 * @param user
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin_login.action")
	public ModelAndView login(Admin admin,HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		String vcode = request.getParameter("vcode");//界面输入的验证码,存在request中
		String rand = session.getAttribute("rand").toString();//image.jsp生成的验证码，存在session中
		if(!rand.equals(vcode)){
			request.setAttribute("errormsg", "验证码错误");
		}else {
			admin=adminBiz.login(admin);      
			if(admin!=null){
				session.setAttribute("admin", admin);
				mav.setViewName("main");
				return mav;
			}else {
				request.setAttribute("errormsg", "用户名或密码错误");
			}
		}
		mav.setViewName("login");
		return mav;
	}
}
