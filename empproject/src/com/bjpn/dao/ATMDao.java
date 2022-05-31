package com.bjpn.dao;

import com.bjpn.bean.ATM;

import java.sql.Connection;

public interface ATMDao {
    ATM login(Connection conn, String code, String pwd);
}
