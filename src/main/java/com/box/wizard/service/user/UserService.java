package com.box.wizard.service.user;

import com.box.wizard.dto.user.JwtReq;
import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.dto.user.UserLoginDTO;

public interface UserService {

    public boolean Join(UserJoinDTO userJoinDTO) ;

    public boolean IdCheck(String userID);

    public JwtReq Login(UserLoginDTO userLoginDTO);

}
