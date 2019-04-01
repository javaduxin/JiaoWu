package lgl.servlet;

import entity.Student;
import lgl.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentDao dao=new StudentDao();

        List<Student> list=dao.queryStu();

        req.setAttribute("stulist",list);
        req.getRequestDispatcher("recode.jsp").forward(req,resp);
    }
}
