package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserDetailsImpl;
import com.example.demo.reposetory.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("user nor found "+username));
        return user.map(UserDetailsImpl::new).get();
    }
}
