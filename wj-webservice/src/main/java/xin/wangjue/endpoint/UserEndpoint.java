package xin.wangjue.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xin.wangjue.ws.GetUserRequest;
import xin.wangjue.ws.GetUserResponse;
import xin.wangjue.ws.Language;
import xin.wangjue.ws.User;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://wangjue.xin/ws";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = new User();
        user.setUserName(request.getUserName());
        user.setName("王珏");
        user.setSex("男");
        user.setAge(28);
        user.setLanguage(Language.DOCKER);
        response.setUser(user);
        return response;
    }
}