package xin.wangjue.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import xin.wangjue.domain.User;
import xin.wangjue.service.IDubbooService;

import java.util.ArrayList;
import java.util.List;


@Service(interfaceClass = IDubbooService.class)
@Component
public class DubbooServiceImpl implements IDubbooService {
    @Override
    public String sayHi() {
        return "Hello World!";
    }

    @Override
    public List<User> listUsers() {
        return createUsers();
    }

    @Override
    public User getUserById(int userId) {
        return createUsers().stream().filter(t -> t.getUserId().intValue() == userId).findFirst().orElse(null);
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"aa","AA"));
        users.add(new User(2,"bb","BB"));
        users.add(new User(3,"cc","CC"));
        return users;
    }
}
