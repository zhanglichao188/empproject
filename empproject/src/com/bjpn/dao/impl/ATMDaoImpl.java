package com.bjpn.dao.impl;

import com.bjpn.bean.ATM;
import com.bjpn.dao.ATMDao;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ATMDaoImpl implements ATMDao {
    @Override
    public ATM login(Connection conn, String code, String pwd) {
        PreparedStatement psta= null;
        ResultSet resultSet = null;
        try {
            String sql = "select *  from atm where atm_code = ? and atm_pwd= ?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,code);
            psta.setString(2,pwd);
            System.out.println("执行的sql："+psta);
            resultSet = psta.executeQuery();
            if(resultSet.next()){
                ATM atm = new ATM();
                atm.setAtmMoney(resultSet.getDouble("atm_money"));
                atm.setAtmPwd(resultSet.getString("atm_pwd"));
                atm.setAtmName(resultSet.getString("atm_name"));
                atm.setAtmId(resultSet.getInt("atm_id"));
                atm.setAtmCode(resultSet.getString("atm_code"));
                return atm;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(psta);
        }
        return null;
    }
}
