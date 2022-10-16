package webclient.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import webclient.backend.security.AppSecurityConfig;

/**
 * Implementation of {@link SecurityService} interface
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */

@Slf4j
@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private AppSecurityConfig appSecurityConfig;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autoLogin(String email, String password) {
        log.info("1.0 зашли в метод autoLogin()");
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        log.info("1.1 получили userDetails");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        try {
            appSecurityConfig.authenticationManagerBean().authenticate(authenticationToken);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("authenticationManagerBean throws exception");
        }

        if(authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            log.info(String.format("Succesfully %s auto logged in", email));
        }

    }
}

