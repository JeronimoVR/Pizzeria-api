package com.jeronimo.pizzeria.service;

import com.jeronimo.pizzeria.persitence.entity.UserEntity;
import com.jeronimo.pizzeria.persitence.entity.UserRoleEntity;
import com.jeronimo.pizzeria.persitence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRespository;

    @Autowired
    public UserSecurityService(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRespository.findById(username)
                .orElseThrow(()->new UsernameNotFoundException("User "+ username+" not found"));

        String[] roles = userEntity.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(roles)
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisable())
                .build();
    }
}
