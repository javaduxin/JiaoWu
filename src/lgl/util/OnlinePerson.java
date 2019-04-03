package lgl.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.ws.spi.http.HttpContext;

//在线监听session
public class OnlinePerson implements HttpSessionListener {


    //session创建调用
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //上下文对象
        ServletContext context= httpSessionEvent.getSession().getServletContext();
        //当前登录在线人数
        Integer userCount= (Integer)context.getAttribute("userCount");

        if(null==userCount){
            userCount=new Integer(1);
        }else{
            userCount=new Integer(userCount+1);
        }
        context.setAttribute("userCount",userCount);
    }
    //session销毁调用
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //上下文对象
        ServletContext context= httpSessionEvent.getSession().getServletContext();
        //当前登录在线人数
        Integer userCount= (Integer)context.getAttribute("userCount");

        if(null==userCount){
            userCount=new Integer(1);
        }else{
            userCount=new Integer(userCount-1);
        }
        context.setAttribute("userCount",userCount);
    }
}
