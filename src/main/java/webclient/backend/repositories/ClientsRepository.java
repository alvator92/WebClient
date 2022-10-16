package webclient.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webclient.backend.model.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {



}
