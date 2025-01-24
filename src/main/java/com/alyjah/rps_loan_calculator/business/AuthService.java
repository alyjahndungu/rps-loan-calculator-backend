package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.model.UserModel;
import org.apache.coyote.BadRequestException;

public interface AuthService {

    UserModel authenticate(String username, String password) throws BadRequestException;
}
