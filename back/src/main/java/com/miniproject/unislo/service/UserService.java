package com.miniproject.unislo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniproject.unislo.entity.UserEntity;
import com.miniproject.unislo.repository.UserRepository;

@Service
@Transactional // 로직 처리시 에러 발생하면, 변경된 데이터 로직이 실행 전으로 콜백
public class UserService {

    @Autowired
    UserRepository userRepo;

    private void validuteDuplicateUser(UserEntity userEntity) {
        UserEntity findUser = userRepo.findByUserId(userEntity.getUserId());
        if(findUser != null){
            throw new IllegalAccessError("이미 가입된 회원입니다.");
        }
    }

    public UserEntity saveUser(UserEntity userEntity){
        validuteDuplicateUser(userEntity);
        return userRepo.save(userEntity);
    }

}
