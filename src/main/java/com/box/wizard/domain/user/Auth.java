package com.box.wizard.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name="auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authindex")
    private Long authIndex;

    private String refreshToken;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Builder
    public Auth(String refreshToken, User user) {
        this.refreshToken = refreshToken;
        this.user = user;
    }
    public void refreshUpdate(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
