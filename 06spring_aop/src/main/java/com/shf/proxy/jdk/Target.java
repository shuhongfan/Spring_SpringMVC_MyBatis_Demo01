package com.shf.proxy.jdk;

import com.shf.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running......");
    }
}
