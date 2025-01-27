package com.alyjah.rps_loan_calculator.api;

import com.alyjah.rps_loan_calculator.business.AuthService;
import com.alyjah.rps_loan_calculator.business.JwtService;
import com.alyjah.rps_loan_calculator.domain.model.UserModel;
import com.alyjah.rps_loan_calculator.domain.request.LoginRequest;
import com.alyjah.rps_loan_calculator.domain.response.LoginResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthService authService, JwtService jwtService, UserDetailsService userDetailsService) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) throws BadRequestException {
        UserModel authenticatedUser = authService.authenticate(request.username(), request.password());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticatedUser.username());
        String jwtToken = jwtService.generateToken(userDetails);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
