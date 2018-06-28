package xin.wangjue.service;

import xin.wangjue.domain.User;

import java.util.List;

public interface IDubbooService {
    String sayHi();
    List<User> listUsers();
    User getUserById(int userId);
}
