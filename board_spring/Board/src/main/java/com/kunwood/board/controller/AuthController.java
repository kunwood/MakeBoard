package com.kunwood.board.controller;

import com.kunwood.board.dto.ResponseDto;
import com.kunwood.board.dto.SignUpDto;
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

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody){
        System.out.println(requestBody.toString());
        return null;
    }
}
