package com.vivacredit.demo.auth.jwt.response;

import java.io.Serializable;

/**
 * JwtResponse
 *
 * @author nandan.kelkar
 */

public class JwtResponse implements Serializable {

    /** */
    private static final long serialVersionUID = 188885641049882931L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return jwttoken;
    }
}