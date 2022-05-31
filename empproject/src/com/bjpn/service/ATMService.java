package com.bjpn.service;

import com.bjpn.bean.ATM;

public interface ATMService {
    ATM login(String code, String pwd);
}
