package com.alkemy.ong.auth.service;

import com.alkemy.ong.auth.config.SecurityConfiguration;

import com.alkemy.ong.dto.UserDto;
import com.alkemy.ong.model.User;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepositiry;
    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User userEntity = userRepositiry.findByEmail(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("The username or password is incorrect");
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
    }

    @Transactional()
    public boolean save(UserDto userDto) throws Exception {
        String encrypted = securityConfiguration.passwordEncoder().encode(userDto.getPassword());
        User userEntity = new User();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(encrypted);
        User userResult;
        userResult = this.userRepositiry.save(userEntity);
        return userResult != null;

    }
}