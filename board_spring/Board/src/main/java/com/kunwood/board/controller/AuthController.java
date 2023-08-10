package com.kunwood.board.controller;

import com.kunwood.board.dto.ResponseDto;
import com.kunwood.board.dto.SignInDto;
import com.kunwood.board.dto.SignInResponseDto;
import com.kunwood.board.dto.SignUpDto;
import com.kunwood.board.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : com.kunwood.board.controller
 * fileName : AuthController
 * author : geonu
 * date : 2023/08/08
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/08         geonu          최초 생성
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody){
        ResponseDto<?> result = authService.signUp(requestBody);
        return null;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody){
        ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
        return result;
    }



}
