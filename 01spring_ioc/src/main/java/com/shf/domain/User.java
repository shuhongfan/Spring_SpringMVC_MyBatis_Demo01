package com.shf.domain;

public class User {
    private String name;
    private String addr;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addrad) {
        this.addr = addrad;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addrad='" + addr + '\'' +
                '}';
    }
}
