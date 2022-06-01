package com.bjpn.service;

import com.bjpn.bean.Emp;

import java.util.List;

public interface EmpService {

    /**
     * 保存员工
     * @param emp
     * @return
     */
    boolean savaEmp(Emp emp);

    /**
     *
     * @return
     */
    List<Emp> findAllEmp();

    /**
     *
     * @param empNo
     * @return
     */
    boolean deleteEmp(String empNo);
}
