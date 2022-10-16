package webclient.backend.service;

import webclient.backend.model.User;

/**
 * Service class for {@link User}
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */
public interface UserService {

    void save(User user);

    User findByUserName(String username);

    User findByEmail(String email);

}
