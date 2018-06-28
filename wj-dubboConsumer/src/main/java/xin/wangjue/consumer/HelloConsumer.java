package xin.wangjue.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import xin.wangjue.service.IDubbooService;

@Component
public class HelloConsumer {
    @Reference(url = "dubbo://192.168.2.119:20880")
    private IDubbooService iDubbooService;

    public void hi() {
        String message = iDubbooService.sayHi();
        System.out.println("dubbo say : "+message);
    }
}
