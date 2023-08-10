package com.kunwood.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.kunwood.board.dto
 * fileName : SignInDto
 * author : geonu
 * date : 2023/08/10
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/10         geonu          최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotBlank
    public String userEmail;
    @NotBlank
    public String userPassword;
}
