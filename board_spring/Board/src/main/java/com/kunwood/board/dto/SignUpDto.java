package com.kunwood.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.kunwood.board.dto
 * fileName : SignUpDto
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String userEmail;
    private String userPassword;
    private String userPasswordCheck;
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userAddressDetail;

}
