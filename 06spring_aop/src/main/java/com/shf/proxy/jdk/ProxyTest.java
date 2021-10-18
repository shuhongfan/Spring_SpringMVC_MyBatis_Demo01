package com.shf.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
//        目标对象
        final Target target = new Target();

//        增强对象
        Advice advice = new Advice();

        TargetInterface proxy= (TargetInterface) Proxy.newProxyInstance(
//                目标对象类加载器
                target.getClass().getClassLoader(),
//                目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
//                    调用代理对象的任何返回 实质执行的都是invoke返回
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        前置增强
                        advice.before();
//                        执行目标方法
                        method.invoke(target,args);
//                        后置增强
                        advice.afterReturning();
                        return null;
                    }
                }
        );
        proxy.save();
    }
}
