package com.vivacredit.demo.auth.jwt.response;

import java.io.Serializable;

import com.vivacredit.demo.entity.UserPrincipal;

/**
 * JwtResponse
 *
 * @author nandan.kelkar
 */

public class JwtResponse implements Serializable {

    /** */
    private static final long serialVersionUID = 188885641049882931L;
    private final UserPrincipal userPrincipal;
    private final String jwttoken;

    public JwtResponse(UserPrincipal userDetails, String jwttoken) {
        userPrincipal = userDetails;
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return jwttoken;
    }

    public UserPrincipal getUserDetails() {
        return userPrincipal;
    }
}