package com.dubbodemo.test.dubbo;

/**
 * Created by liwenqing on 2018/7/2.
 */
public class DubboServiceImpl implements IDubboService{
    @Override
    public String getString() {
        return "Hello dubbo";
    }
}
