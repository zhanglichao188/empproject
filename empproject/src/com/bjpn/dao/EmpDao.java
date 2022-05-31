package com.bjpn.dao;

import com.bjpn.bean.Emp;

import java.sql.Connection;
import java.util.List;

public interface EmpDao {
    boolean saveEmp(Connection conn, Emp emp);
    List<Emp> findAllEmp(Connection conn);
    boolean deleteEmp(Connection conn, String empNo);
}
