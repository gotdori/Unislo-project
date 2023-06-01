package com.miniproject.unislo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.miniproject.unislo.constant.Role;
import com.miniproject.unislo.dto.UserDto;

import lombok.Data;

@Data
@Table(name = "USER_TABLE")
@Entity
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    private String userId; // 회원 아이디(이메일)
    @Column(name = "USER_NM")
    private String userNm; // 회원명
    @Column(name = "USER_PW")
    private String userPw; // 비밀번호
    @Column(name = "USER_TELNO")
    private String userTelno; // 회원 전화번호
    @Column(name = "USER_YN")
    private String userYn; // 회원 탈퇴 여부
    @Enumerated(EnumType.STRING) //enum 엔티티로 적용. 순서가 바뀌지 않게 String으로 저장
    private Role role; // 관리자 여부


    public static UserEntity toUserEntity(UserDto userDto, PasswordEncoder passwordEncoder) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserNm(userDto.getUserNm());
         // securityConfig에 등록한 BCryptPasswordEncoder Bean을 파라미터로 넘겨서 비밀번호를 암호화 함
        String UserPw = passwordEncoder.encode(userDto.getUserPw());
        userEntity.setUserPw(UserPw);
        userEntity.setUserTelno(userDto.getUserTelno());
        userEntity.setUserYn(userDto.getUserYn());
        userEntity.setRole(Role.USER);

        return userEntity;

    }
}
