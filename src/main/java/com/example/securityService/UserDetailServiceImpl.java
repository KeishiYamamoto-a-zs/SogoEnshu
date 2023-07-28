package com.example.securityService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.vegetable.model.UserEntity;
import com.example.service.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private UserService service;
	
	@Autowired
	public UserDetailServiceImpl(@Lazy UserService service) {
		this.service = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // ユーザー情報取得
        UserEntity loginUser = service.getLoginUser(username);

        // ユーザーが存在しない場合
        if(loginUser == null) {
            throw new UsernameNotFoundException("user not found");
        }

        // 権限List作成
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        // UserDetails生成
        UserDetails userDetails = (UserDetails) new User(loginUser.getMailaddress(), loginUser.getPassword(), authorities);

        return userDetails;

}

}
