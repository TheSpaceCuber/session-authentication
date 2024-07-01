package com.example.sessionauth.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Component;

@Component(value = "customLogoutHandler")
public class CustomLogoutHandler implements LogoutHandler {

    private final FindByIndexNameSessionRepository<? extends Session> jdbcIndexedSessionRepository;

    public CustomLogoutHandler(JdbcIndexedSessionRepository jdbcIndexedSessionRepository) {
        this.jdbcIndexedSessionRepository = jdbcIndexedSessionRepository;
    }

    /**
     * Method responsible for deleting user session from redis
     *
     * @param request
     * @param response
     * @param authentication
     * @return void
     * */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String id = request.getSession(false).getId();
        if (id != null && this.jdbcIndexedSessionRepository.findById(id) != null) {
            this.jdbcIndexedSessionRepository.deleteById(id);
        }
    }

}
