package com.box.wizard.repository.user;

import com.box.wizard.domain.user.Auth;
import com.box.wizard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Auth findByUser(User user);

}
