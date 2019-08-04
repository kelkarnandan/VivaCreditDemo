package com.vivacredit.demo.auth.jwt.util;

public class JwtSecurityConstants {

    public static final String SECRET = "VivaCreditDemo";
    public static final long EXPIRATION_TIME = 120_000; // 2 minute
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String LOGIN_URL = "/login";
    public static final String AUTHENTICATE_URL = "/authenticate";
}
