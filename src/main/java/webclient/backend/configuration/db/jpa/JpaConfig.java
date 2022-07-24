package webclient.backend.configuration.db.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import webclient.backend.service.ClientsService;
import webclient.backend.serviceimpl.ClientsServiceImpl;

@Configuration
@EnableJpaRepositories( basePackages = {"webclient.backend.repositories"},
        entityManagerFactoryRef = "apossEntityManager",
        transactionManagerRef = "apossTransactionManager")
public class JpaConfig {

    @Bean("ClientsService")
    public ClientsService clientsService() {
        return new ClientsServiceImpl();
    }
}
