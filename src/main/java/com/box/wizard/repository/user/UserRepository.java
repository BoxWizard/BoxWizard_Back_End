package com.box.wizard.repository.user;

import com.box.wizard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserID(String userID);

    User findByUserIDAndUserPW(String userID, String userPW);
}
