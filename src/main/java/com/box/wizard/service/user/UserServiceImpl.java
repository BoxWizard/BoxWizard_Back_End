package com.box.wizard.service.user;

import com.box.wizard.commons.jwt.JwtTokenProvider;
import com.box.wizard.domain.user.Auth;
import com.box.wizard.domain.user.User;
import com.box.wizard.dto.user.JwtReq;
import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.dto.user.UserLoginDTO;
import com.box.wizard.repository.user.AuthRepository;
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

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private final AuthRepository authRepository;

    @Override
    public boolean Join(UserJoinDTO userJoinDTO) {


        User user = userRepository.save(
                        User.builder()
                                .userID(userJoinDTO.getUserID())
                                .userPW(userJoinDTO.getUserPW())
                                .userName(userJoinDTO.getUserName())
                                .telNumber(userJoinDTO.getTelNumber())
                                .walletAddress(userJoinDTO.getWalletAddress())
                                .userAddress(userJoinDTO.getUserAddress())
                                .build()
        );


        String refreshToken = jwtTokenProvider.saveRefreshToken(user);

        authRepository.save(
                Auth.builder().user(user).refreshToken(refreshToken).build()
        );

        return true;
    }

    @Override
    public boolean IdCheck(String userID) {


        if(userRepository.existsByUserID(userID)) {
            return true;
        }

        return false;
    }

    @Override
    public JwtReq Login(UserLoginDTO userLoginDTO) {

        User user = userRepository.findByUserIDAndUserPW(userLoginDTO.getUserID(), userLoginDTO.getUserPW());

        if(user != null) {
            JwtReq jwtReq = new JwtReq();
            jwtReq.setAccessToken(jwtTokenProvider.generateJwtToken(user));
            jwtReq.setRefreshToken(authRepository.findByUser(user).getRefreshToken());

            return jwtReq;
        }

        return null;
    }
}
