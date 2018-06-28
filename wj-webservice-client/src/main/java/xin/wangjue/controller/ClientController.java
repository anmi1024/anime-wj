package xin.wangjue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.wangjue.client.WsClient;
import xin.wangjue.ws.GetUserResponse;

@RestController
public class ClientController {

    @Autowired
    private WsClient wsClient;

    @RequestMapping("user")
    public Object user() {
        GetUserResponse response =  wsClient.getUser("wwjj");
        return response.getUser();
    }

}
