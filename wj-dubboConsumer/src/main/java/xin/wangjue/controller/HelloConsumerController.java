package xin.wangjue.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.wangjue.domain.User;
import xin.wangjue.service.IDubbooService;
import xin.wangjue.utils.View;

import java.util.List;

@RestController
public class HelloConsumerController {
    @Reference(url = "dubbo://127.0.0.1:20880")
    private IDubbooService iDubbooService;

    @RequestMapping("/")
    public String index() {
        return "index page";
    }

    @RequestMapping("/dubbo/test")
    public String test() {
        return "test successfully";
    }

    @RequestMapping("/dubbo/hi")
    public String hi() {
        return "dubbo say : " + iDubbooService.sayHi();
    }

    @RequestMapping("/dubbo/get/{userId}")
    public View<User> get(@PathVariable Integer userId) {
        View<User> view = new View<>();
        view.setTimestamp(System.currentTimeMillis());
        User user = iDubbooService.getUserById(userId);
        if (user == null) {
            view.setStatus(false);
            view.setMessage("userId:"+userId+" ,查询失败!");
        } else {
            view.setStatus(true);
            view.setMessage("查询成功");
        }
        view.setObject(user);
        return view;
    }

    @RequestMapping("/dubbo/get")
    public List<User> list() {
        return iDubbooService.listUsers();
    }
}
