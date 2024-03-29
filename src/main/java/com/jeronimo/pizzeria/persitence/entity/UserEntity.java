package com.jeronimo.pizzeria.persitence.entity;

import com.jeronimo.pizzeria.persitence.audit.AuditPizzaListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(nullable = false,length = 20)
    private String username;

    @Column(nullable = false,length = 200)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(nullable = false,columnDefinition = "TINYINT")
    private Boolean locked;

    @Column(nullable = false,columnDefinition = "TINYINT")
    private Boolean disable;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", locked=" + locked +
                ", disable=" + disable +
                ", roles=" + roles +
                '}';
    }
}
