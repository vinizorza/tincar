package com.zortech.tincar.controller;

import com.zortech.tincar.config.jwt.JwtRequest;
import com.zortech.tincar.config.jwt.JwtTokenUtil;
import com.zortech.tincar.dto.UserDTO;
import com.zortech.tincar.service.JwtUserDetailsService;
import com.zortech.tincar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Long id){
        return UserDTO.from(userService.getById(id));
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDTO dto){
        userService.save(UserDTO.from(dto));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        return jwtTokenUtil.generateToken(userDetails);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
