package com.box.wizard.service.user;

import com.box.wizard.domain.user.User;
import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        System.out.println("유저임 : "+user.getUserID());
        System.out.println("유저임 : "+user.getUserPW());
        System.out.println("유저임 : "+user.getUserName());
        System.out.println("유저임 : "+user.getTelNumber());
        System.out.println("유저임 : "+user.getWalletAddress());
        System.out.println("유저임 : "+user.getUserAddress());

        userRepository.save(user);

        return true;
    }
}
