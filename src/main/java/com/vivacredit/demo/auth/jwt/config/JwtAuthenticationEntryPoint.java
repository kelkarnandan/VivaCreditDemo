package com.vivacredit.demo.auth.jwt.config;

import org.springframework.stereotype.Component;

/**
 * JwtAuthenticationEntryPoint
 *
 * @author nandan.kelkar
 */

@Component
public class JwtAuthenticationEntryPoint {

}
// implements AuthenticationEntryPoint, Serializable {
//
// /** */
// private static final long serialVersionUID = 229681188627215551L;
//
// @Override
// public void commence(HttpServletRequest request, HttpServletResponse response,
// AuthenticationException authException) throws IOException {
// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
// }
// }