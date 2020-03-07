package com.pharmacy.user;

import com.pharmacy.user.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

public class PharmacyUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;
    private String password;
    private int active;
    private Set<GrantedAuthority> authorities = new HashSet<>();

    public PharmacyUserDetails(){ }

    PharmacyUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        //TODO: should be isActive which is correlated with database type
        this.active = user.getActive();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active == 1;
    }
}
