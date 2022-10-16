package webclient.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import webclient.backend.model.Roles;
import webclient.backend.model.User;
import webclient.backend.repositories.RoleRepository;
import webclient.backend.repositories.UserRepository;
import webclient.backend.security.AppSecurityConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AppSecurityConfig appSecurityConfig;

    @Override
    public void save(User user) {
        user.setPassword(appSecurityConfig.passwordEncoder().encode(user.getPassword()));
        Set<Roles> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
