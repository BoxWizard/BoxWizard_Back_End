package com.box.wizard.domain.user;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userindex")
    private Integer userIndex;

    @Column(name = "userid",nullable = false, unique = true)
    private String userID;

    @Column(name = "userpw",nullable = false)
    private String userPW;

    @Column(name = "username",nullable = false)
    private String userName;

    @Column(name = "telnumber",nullable = false, unique = true)
    private String telNumber;

    @Column(name = "walletaddress",nullable = false, unique = true)
    private String walletAddress;

    @Column(name = "useraddress",nullable = false)
    private String userAddress;
}
