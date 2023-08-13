package com.kunwood.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.kunwood.board.controller
 * fileName : BoardController
 * author : geonu
 * date : 2023/08/13
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/13         geonu          최초 생성
 */
@RestController
@RequestMapping("/api/board")
public class BoardController {
    @GetMapping("/")
    public String getBoard(@AuthenticationPrincipal String userEmail) {
        return "로그인된 사용자는 " + userEmail + "입니다.";
    }
}
