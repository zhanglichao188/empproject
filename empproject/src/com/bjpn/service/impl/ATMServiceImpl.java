package com.bjpn.service.impl;

import com.bjpn.bean.ATM;
import com.bjpn.dao.ATMDao;
import com.bjpn.dao.impl.ATMDaoImpl;
import com.bjpn.service.ATMService;
import com.bjpn.util.DBUtil;

import java.sql.Connection;

public class ATMServiceImpl implements ATMService {
    ATMDao empDao=new ATMDaoImpl();
    @Override
    public ATM login(String code, String pwd) {
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            ATM atm = empDao.login(conn, code, pwd);
            return atm;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
        }
        return null;
    }
}
