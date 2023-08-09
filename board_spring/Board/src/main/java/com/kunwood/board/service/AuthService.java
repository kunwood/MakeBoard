package com.kunwood.board.service;

import com.kunwood.board.dto.ResponseDto;
import com.kunwood.board.dto.SignUpDto;
import com.kunwood.board.entity.UserEntity;
import com.kunwood.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName : com.kunwood.board.service
 * fileName : AuthService
 * author : geonu
 * date : 2023/08/09
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/09         geonu          최초 생성
 */
@Service
public class AuthService {

    @Autowired UserRepository userRepository;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

//        Email 중복확인
        try {
            if(userRepository.existsById(userEmail))
                return ResponseDto.setFailed("Existed Email!");
        }catch (Exception e){
            return ResponseDto.setFailed("Data Base Error!");
        }


//       비밀번호가 서로 다르면 failed response 반환!
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("Password does not matched!");

//        UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);

//        UserRepository를 이용해서 데이터베이스에 Entity 저장!
        try{
            userRepository.save(userEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 성공시 success response 반환!
        return ResponseDto.setSuccess("Sign Up Success!", null);
    }
}
