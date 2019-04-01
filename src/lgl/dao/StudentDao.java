package lgl.dao;

import base.BaseDao;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//学生管理
public class StudentDao extends BaseDao {


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
