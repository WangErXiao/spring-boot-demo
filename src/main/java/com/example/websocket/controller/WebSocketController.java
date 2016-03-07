package com.example.websocket.controller;

import com.example.websocket.vo.CalcInput;
import com.example.websocket.vo.Result;
import com.example.websocket.vo.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by yao on 16/2/25.
 */
@Controller
public class WebSocketController {


    @MessageMapping("/add" )
    @SendTo("/topic/showResult")
    public Result addNum(CalcInput input) throws Exception {
        Thread.sleep(2000);
        Result result = new Result(input.getNum1()+"+"+input.getNum2()+"="+(input.getNum1()+input.getNum2()));
        return result;
    }


    @MessageMapping("/user" )
    @SendTo("/topic/showUsers")
    public User showUsers(User user) throws Exception {
        return user;
    }


}
