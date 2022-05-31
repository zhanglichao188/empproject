package com.bjpn.service;

import com.bjpn.bean.Emp;

import java.util.List;

public interface EmpService {
    boolean savaEmp(Emp emp);
    List<Emp> findAllEmp();
}
