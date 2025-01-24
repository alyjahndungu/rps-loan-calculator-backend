
package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.model.UserModel;
import com.alyjah.rps_loan_calculator.exception.BadCredentialsException;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public UserModel authenticate(String username, String password) throws BadRequestException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new BadRequestException("Incorrect email or password");
        }

        return getUsers().stream()
                .filter(u -> u.username().equalsIgnoreCase(username))
                .findFirst().orElseThrow();
    }


    public List<UserModel> getUsers() {
        return Arrays.asList(
                new UserModel("johndoe@example.com", "password"),
                new UserModel("marydoe@example.com", "password")
        );
    }
}
