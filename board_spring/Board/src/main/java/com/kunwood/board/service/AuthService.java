package com.kunwood.board.service;

import com.kunwood.board.dto.ResponseDto;
import com.kunwood.board.dto.SignInDto;
import com.kunwood.board.dto.SignInResponseDto;
import com.kunwood.board.dto.SignUpDto;
import com.kunwood.board.entity.UserEntity;
import com.kunwood.board.repository.UserRepository;
import com.kunwood.board.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

//        Email 중복확인
        try {
            if (userRepository.existsById(userEmail))
                return ResponseDto.setFailed("Existed Email!");
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }


//       비밀번호가 서로 다르면 failed response 반환!
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("Password does not matched!");

//        UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);

//       비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userPassword);
        userEntity.setUserPassword(encodedPassword);


//        UserRepository를 이용해서 데이터베이스에 Entity 저장!
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 성공시 success response 반환!
        return ResponseDto.setSuccess("Sign Up Success!", null);
    }


    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        try {
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if (!existed) return ResponseDto.setFailed("Sign In Information Does Not Match");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }


        UserEntity userEntity = null;


        try {
            userEntity = userRepository.findById(userEmail).get();
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }


        userEntity.setUserPassword("");


        String token = tokenProvider.create(userEmail);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
    }
}
