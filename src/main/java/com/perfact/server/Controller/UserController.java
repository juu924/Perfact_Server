package com.perfact.server.Controller;

import com.perfact.server.Service.UserService;
import com.perfact.server.dto.Response;
import com.perfact.server.dto.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Response login(@RequestBody UserRequestDto userRequestDto) {
        if (userService.login(userRequestDto.getEmail(), userRequestDto.getPasswd()).equals("Success")) {
            return Response.builder()
                    .code("201")
                    .messages("로그인에 성공하였습니다. userId =" + userService.getMemberId(userRequestDto.getEmail()))
                    .build();
        }else{
            return Response.builder()
                    .code("401")
                    .messages("로그인에 실패하였습니다.")
                    .build();
        }
    }

}
