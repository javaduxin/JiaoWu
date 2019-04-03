package lgl.servlet;

import entity.Student;
import lgl.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentDao dao=new StudentDao();
        //从表单获取账号密码
        Integer username=Integer.parseInt(req.getParameter("username"));
        String password=req.getParameter("password");


        //登录方法
        Student student= dao.login(username,password);

        if(student!=null){
            //登录成功以后判断用户是否记住账号
            String ck=req.getParameter("rem");
            if("1".equals(ck)){
                //Cookie cookie=new Cookie("user",URLEncoder.encode(username,"UTF-8"));
                //使用cookie记住账号
                Cookie cookie=new Cookie("userName",username+"");
                //设置cookie生命周期
                cookie.setMaxAge(1*60);
                resp.addCookie(cookie);
            }

            HttpSession session= req.getSession();
            session.setAttribute("studentSession",student);
            resp.sendRedirect("index.jsp");
        }else{
            resp.sendRedirect("login.jsp");
        }



    }
}
