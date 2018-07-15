
package com.alibaba.testsdk.service;

import com.alibaba.testsdk.packet.generic.AutoLoginRestRequestBody;
import com.alibaba.testsdk.packet.generic.LoginRestRequestBody;
import com.alibaba.testsdk.packet.generic.LoginRestResponseBody;
import com.alibaba.testsdk.packet.generic.RegistserRestRequestBody;


/**
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的
 * 
 * @Copyright 2018 快嘉框架. All rights reserved.
 * @author cuiyingfeng
 */
public interface UserServiceRPC {


    /**
     * 注册
     * 
     */
    void register(RegistserRestRequestBody request);

    /**
     * 登录
     * 
     */
    LoginRestResponseBody login(LoginRestRequestBody request);

    /**
     * 登录v1.1
     * 
     */
    LoginRestResponseBody loginv1_1(LoginRestRequestBody request);

    /**
     * 自动登录
     * 
     */
    LoginRestResponseBody autoLogin(AutoLoginRestRequestBody request);

}
