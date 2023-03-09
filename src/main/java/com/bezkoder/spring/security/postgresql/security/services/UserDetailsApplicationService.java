package com.bezkoder.spring.security.postgresql.security.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import com.bezkoder.spring.security.postgresql.usuario.application.repository.UserRepositoryOld;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserDetailsApplicationService implements UserDetailsService {

    private final UserRepositoryOld userRepositoryOld;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("[inicia] UserDetailsServiceImpl - loadUserByUsername");
    User user = userRepositoryOld.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    log.info("[finaliza] UserDetailsServiceImpl - loadUserByUsername");
    return UserDetailsImpl.build(user);
    }
}
