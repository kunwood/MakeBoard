package com.kunwood.board.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.kunwood.board.controller
 * fileName : MainController
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
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String hello(){
        return "Connection Successful";
    }
}
