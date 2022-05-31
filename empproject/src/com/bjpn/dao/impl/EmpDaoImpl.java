package com.bjpn.dao.impl;

import com.bjpn.bean.Emp;
import com.bjpn.dao.EmpDao;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public boolean saveEmp(Connection conn, Emp emp) {
        PreparedStatement psta = null;
        try {
            String sql="insert into emp (emp_name,emp_job,hiredate,emp_sal,emp_photo,dept_no)values(?,?,?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1, emp.getEmpName());
            psta.setString(2, emp.getEmpJob());
            psta.setString(3, emp.getEmpHiredate());
            psta.setDouble(4, emp.getEmpSal());
            psta.setString(5, emp.getEmpPhoto());
            psta.setInt(6, emp.getEmpNo());
            int num = psta.executeUpdate();
            if (num>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePsta(psta);
        }
        return false;
    }

    @Override
    public List<Emp> findAllEmp(Connection conn) {
        PreparedStatement psta= null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from emp";
            psta = conn.prepareStatement(sql);
            resultSet = psta.executeQuery();
            List<Emp> list = new ArrayList<>();
            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpPhoto(resultSet.getString("emp_photo"));
                emp.setEmpJob(resultSet.getString("emp_job"));
                emp.setEmpHiredate(resultSet.getString("hiredate"));
                emp.setEmpSal(resultSet.getDouble("emp_sal"));
                emp.setEmpNo(resultSet.getInt("emp_no"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setDeptNo(resultSet.getInt("dept_no"));
                list.add(emp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(psta);
        }
        return null;
    }

    @Override
    public boolean deleteEmp(Connection conn,String empNo) {
        PreparedStatement psta = null;
        try {
            String sql = "delete from emp where emp_no=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1, empNo);
            int num = psta.executeUpdate();
            if (num>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePsta(psta);
        }
        return false;
    }
}
