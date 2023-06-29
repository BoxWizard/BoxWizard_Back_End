package com.box.wizard.service.user;

import com.box.wizard.domain.user.User;
import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public boolean Join(UserJoinDTO userJoinDTO) {

        User user = User.builder()
                .userID(userJoinDTO.getUserID())
                .userPW(userJoinDTO.getUserPW())
                .userName(userJoinDTO.getUserName())
                .telNumber(userJoinDTO.getTelNumber())
                .walletAddress(userJoinDTO.getWalletAddress())
                .userAddress(userJoinDTO.getUserAddress())
                .build();

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean IdCheck(String userID) {


        if(userRepository.existsByUserID(userID)) {
            return true;
        }

        return false;
    }
}
