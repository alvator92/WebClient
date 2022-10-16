package webclient.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webclient.backend.model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
