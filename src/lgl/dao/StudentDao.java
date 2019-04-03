package lgl.dao;

import base.BaseDao;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//学生管理
public class StudentDao extends BaseDao {



    //学生登录
    public Student login(int stuno,String pwd){
        //连接数据库
        Connection conn=super.getConn();
        //登录学生信息
        Student student=new Student();

        try {
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM `student` WHERE studentno=? AND LoginPwd=? ");
            ps.setInt(1,stuno);
            ps.setString(2,pwd);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){
                //登录成功
                student.setStudentNo(rs.getInt("studentno"));
                student.setStudentName(rs.getString("StudentName"));
                student.setSex(rs.getInt("sex"));
                return student;
            }else{
                return null;//登录失败
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }




    public List<Student> queryStu(){

        Connection conn=super.getConn();

        List<Student> list=new ArrayList<Student>();

        try {
            PreparedStatement ps=conn.prepareStatement("select * from student");

            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Student stu=new Student();
                stu.setStudentNo(rs.getInt("StudentNo"));
                stu.setStudentName(rs.getString("StudentName"));
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
