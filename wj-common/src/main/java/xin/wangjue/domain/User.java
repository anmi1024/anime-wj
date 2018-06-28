package xin.wangjue.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String name;
    private String sex;
    private long age;

    public User(String userName, String name, String sex, long age) {
        this.userName = userName;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
