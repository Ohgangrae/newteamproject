package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.ActionForward;

public class UserFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward af = null;
		
		if(command.equals("/user/controller/UserCheckIdOk.us")) {
			//new UserCheckIdO().execute(req, resp);
			
		}else if(command.equals("/user/controller/UserJoinOk.us")) {
			//af = new UserJoinOk().execute(req, resp);
			
		}else if(command.equals("/user/controller/UserLoginOk.us")) {
			//af = new UserLoginOk().execute(req, resp);
			
		}else if(command.equals("/user/controller/UserLogout.us")) {
			//af = new UserLogout().execute(req, resp);
			
		}else if(command.equals("/user/controller/UserUpdateOk.us")) {
			af = new UserUpdateOk().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdate.us")) {
			af = new UserUpdate().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdateProfile.us")) {
			af = new UserUpdateProfile().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdateProfileOK.us")) {
			af = new UserUpdateProfileOK().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdatePwOK.us")) {
			af = new UserUpdatePwOK().execute(req, resp);
		}else if(command.equals("/user/controller/UserDelUserOK.us")) {
			af = new UserDelUserOK().execute(req, resp);
		}
		//�쟾�넚�븞�븷吏�
		if(af != null) {
			if(af.isRedirect()) {
				//redirect
				resp.sendRedirect(af.getPath());
			}else {
				//forward
				//request媛앹껜�뿉�꽌 Dispatch�쓣 媛��졇�삩 �뮘, �씠�룞�븷 寃쎈줈瑜� �쟾�떖�븳�떎.
				//dispatch : �슂泥�怨� �쓳�떟�쓣 愿�由ы빐二쇰뒗 媛앹껜
				RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
				//dispatcher媛앹껜�뿉�꽌 forward()瑜� �궗�슜�븷 �븣 request�� response媛앹껜 �몮 �떎 �쟾�떖�빐二쇰㈃
				//�쓳�떟�븷 �솕硫닿퉴吏� �뜲�씠�꽣媛� �쑀吏��맂�떎.
				dispatcher.forward(req, resp);
			}
		}
	}
}
















