package webclient.backend.service;

/**
 * Service for Security
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String email, String password);

}
