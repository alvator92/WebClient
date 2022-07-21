package webclient.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webclient.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
