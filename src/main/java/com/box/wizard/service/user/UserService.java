package com.box.wizard.service.user;

import com.box.wizard.dto.user.UserJoinDTO;

public interface UserService {

    public boolean Join(UserJoinDTO userJoinDTO) ;

    public boolean IdCheck(String userID);

}
