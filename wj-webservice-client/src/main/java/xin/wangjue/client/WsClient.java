package xin.wangjue.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import xin.wangjue.ws.GetUserRequest;
import xin.wangjue.ws.GetUserResponse;

public class WsClient extends WebServiceGatewaySupport {
    public static final String URI = "http://localhost:8080/ws/user.wsdl";

    public GetUserResponse getUser(String userName) {
        GetUserRequest request = new GetUserRequest();
        request.setUserName(userName);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(URI,request);
        return response;
    }
}
