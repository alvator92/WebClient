package webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import webclient.backend.common.Common;
import webclient.backend.common.Utils;
import webclient.backend.configuration.db.hibernate.HibernateConfig;
import webclient.backend.model.Clients;
import webclient.backend.repositories.UserRepository;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
//@ComponentScan(basePackages = {"webclient.*", "webclient.backend.configuration.db"})
@ConfigurationPropertiesScan("webclient.backend.configuration")
//@EntityScan(basePackages = "webclient.backend.configuration.model")
@Slf4j
public class StartClass implements CommandLineRunner {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateConfig hibernateConfig;
    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(StartClass.class, args);
//        ctx.getBean("Clients", Clients.class);
        System.out.println("Hello world");

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataSource : " + hibernateConfig);
        System.out.println("DataSource : " + hibernateConfig.masterDataSource());
        System.out.println("DataSource : " + hibernateConfig.masterHikariConfig());

        // проверка пропертей
        Iterator hmIterator = jpaProperties.getProperties().entrySet().iterator();

        while (hmIterator.hasNext()) {
            Map.Entry mapElement
                    = (Map.Entry)hmIterator.next();
            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
        }
    }
}
