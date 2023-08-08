package com.kunwood.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * packageName : com.kunwood.board.dto
 * fileName : ResponseDto
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
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data){

        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message){

        return ResponseDto.set(false, message, null);
    }
}
