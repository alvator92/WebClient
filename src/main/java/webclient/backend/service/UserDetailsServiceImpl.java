package webclient.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webclient.backend.model.Roles;
import webclient.backend.model.User;
import webclient.backend.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // TODO: 12.09.2021 сделать Optional
    final User user = userRepository.findByEmail(email);
    if (user == null) {
        throw new UsernameNotFoundException(email);
    }
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    for (Roles roles : user.getRoles()) {
        grantedAuthorities.add(new SimpleGrantedAuthority(roles.getName()));
    }
    return SecurityUser.fromUser(user, grantedAuthorities);
  }
}
