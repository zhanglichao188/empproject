package com.bjpn.service.impl;

import com.bjpn.bean.Emp;
import com.bjpn.dao.EmpDao;
import com.bjpn.dao.impl.EmpDaoImpl;
import com.bjpn.service.EmpService;
import com.bjpn.util.DBUtil;

import javax.xml.stream.events.Comment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao=new EmpDaoImpl();
    @Override
    public boolean savaEmp(Emp emp) {
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            boolean b = empDao.saveEmp(conn, emp);
            if (b) {
                conn.commit();
                return true;
            } else {
                conn.rollback();

            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
        }
        return false;
    }

    @Override
    public List<Emp> findAllEmp() {
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            List<Emp> empList = empDao.findAllEmp(conn);
            return empList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
        }
        return null;
    }

    @Override
    public boolean deleteEmp(String empNo) {
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            boolean b = empDao.deleteEmp(conn, empNo);
            if (b) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
        }
        return false;
    }
}
