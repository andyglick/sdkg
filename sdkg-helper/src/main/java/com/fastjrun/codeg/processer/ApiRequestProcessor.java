package com.fastjrun.codeg.processer;

import com.fastjrun.codeg.common.CodeGConstants;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;

public class ApiRequestProcessor extends BaseRequestWithHeadProcessor implements CodeGConstants {

    public ApiRequestProcessor() {
        this.requestHeadClass = cm.ref(API_REQUEST_HEAD_CLASS_NAME);
        this.baseRequestClassName = API_REQUEST_CLASS_NAME;
    }

    @Override
    public String processHTTPRequest(JMethod jcontrollerMethod, JInvocation jInvocation,
                                     CodeGConstants.MockModel mockModel) {
        JBlock controllerMethodBlk = jcontrollerMethod.body();
        JVar requestHeadVar = controllerMethodBlk.decl(this.requestHeadClass,
                "requestHead",
                JExpr._new(this.requestHeadClass));
        JVar accessKeyJVar = jcontrollerMethod.param(cm.ref("String"), "accessKey");
        accessKeyJVar.annotate(cm.ref("org.springframework.web.bind.annotation.PathVariable"))
                .param("value", "accessKey");
        controllerMethodBlk.invoke(JExpr.ref("requestHead"), "setAccessKey").arg(JExpr.ref("accessKey"));
        if (mockModel == MockModel.MockModel_Swagger) {
            accessKeyJVar.annotate(cm.ref("io.swagger.annotations.ApiParam")).param("name", "accessKey")
                    .param("value", "接入客户端的accessKey").param("required", true);
        }
        JVar txTimeJVar = jcontrollerMethod.param(cm.ref("Long"), "txTime");
        txTimeJVar.annotate(cm.ref("org.springframework.web.bind.annotation.PathVariable")).param("value",
                "txTime");
        controllerMethodBlk.invoke(JExpr.ref("requestHead"), "setTxTime").arg(JExpr.ref("txTime"));
        if (mockModel == MockModel.MockModel_Swagger) {
            txTimeJVar.annotate(cm.ref("io.swagger.annotations.ApiParam")).param("name", "txTime")
                    .param("value", "接口请求时间戳").param("required", true);
        }
        JVar md5HashJVar = jcontrollerMethod.param(cm.ref("String"), "md5Hash");
        md5HashJVar.annotate(cm.ref("org.springframework.web.bind.annotation.PathVariable")).param("value",
                "md5Hash");
        controllerMethodBlk.invoke(JExpr.ref("requestHead"), "setMd5Hash").arg(JExpr.ref("md5Hash"));
        if (mockModel == MockModel.MockModel_Swagger) {
            md5HashJVar.annotate(cm.ref("io.swagger.annotations.ApiParam")).param("name", "md5Hash")
                    .param("value", "md5Hash").param("required", true);
        }
        controllerMethodBlk.invoke(JExpr._this(), "processHead").arg(requestHeadVar);
        return "/{accessKey}/{txTime}/{md5Hash}";
    }

    @Override
    public void processRPCRequest(JMethod method, JInvocation jInvocation) {

    }
}
