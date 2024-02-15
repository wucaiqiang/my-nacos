package com.sk.user.provider.filter;

import com.alibaba.fastjson.JSONObject;
import com.sk.user.provider.dto.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jack
 *
 */
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

	public static final String HEADER_STRING = "Authorization";
	public static final String SECRET = "SECRET_SK";// 密钥
	public static final String USER_KEY = "USER_KEY";


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String authToken = request.getHeader(HEADER_STRING);
		log.debug("authToken: {}", authToken);
		if (StringUtils.isNotBlank(authToken)) {
			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				Claims mySecret = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken).getBody();
				User userDetails= JSONObject.parseObject((String) mySecret.get(USER_KEY), User.class);
				log.debug("userDetails: {}", userDetails);
				List<GrantedAuthority> lst= (List<GrantedAuthority>) userDetails.getAuthorities();
				if(null == lst){
					lst=new ArrayList<>();
				}
				lst.add(new SimpleGrantedAuthority("user.get"));
				lst.add(new SimpleGrantedAuthority("ROLE_USER_GETBYNAME"));
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, lst);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + userDetails.getUsername() + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}
}
