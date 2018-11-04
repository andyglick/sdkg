package com.fastjrun.codeg.generator;

import com.fastjrun.codeg.generator.method.BaseControllerMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseRPCMethodGenerator;
import com.fastjrun.codeg.generator.method.DefaultRPCMethodGenerator;
import com.fastjrun.codeg.generator.method.ServiceMethodGenerator;
import com.fastjrun.codeg.processer.BaseRequestProcessor;
import com.fastjrun.codeg.processer.BaseResponseProcessor;
import com.fastjrun.codeg.processer.DefaultExchangeProcessor;
import com.fastjrun.codeg.processer.DefaultRequestWithoutHeadProcessor;
import com.fastjrun.codeg.processer.DefaultResponseWithHeadProcessor;

public class DefaultDubboGenerator extends BaseRPCGenerator {

    @Override
    public BaseControllerMethodGenerator prepareBaseControllerMethodGenerator(
            ServiceMethodGenerator serviceMethodGenerator) {
        BaseRPCMethodGenerator baseRPCMethodGenerator = new DefaultRPCMethodGenerator();
        baseRPCMethodGenerator.setClient(this.isClient());
        baseRPCMethodGenerator.setPackageNamePrefix(this.packageNamePrefix);
        baseRPCMethodGenerator.setMockModel(this.mockModel);
        baseRPCMethodGenerator.setServiceMethodGenerator(serviceMethodGenerator);
        baseRPCMethodGenerator.setBaseControllerGenerator(this);
        DefaultExchangeProcessor exchangeProcessor = new DefaultExchangeProcessor();
        BaseRequestProcessor baseRequestProcessor = new DefaultRequestWithoutHeadProcessor();
        BaseResponseProcessor baseResponseProcessor = new DefaultResponseWithHeadProcessor();
        exchangeProcessor.setResponseProcessor(baseResponseProcessor);
        exchangeProcessor.setRequestProcessor(baseRequestProcessor);
        exchangeProcessor.doParse(serviceMethodGenerator, this.packageNamePrefix);
        baseRPCMethodGenerator.setExchangeProcessor(exchangeProcessor);
        return baseRPCMethodGenerator;
    }
}