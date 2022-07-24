package webclient.backend;

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
import webclient.backend.configuration.db.hibernate.HibernateConfig;
import webclient.backend.model.Clients;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {"webclient.backend.*"})
@ConfigurationPropertiesScan("webclient.backend.configuration")
@EntityScan(basePackages = "webclient.backend.*")
//@EnableJpaRepositories( basePackages = "webclient.backend.repositories")
@Slf4j
public class StartClass implements CommandLineRunner {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateConfig hibernateConfig;
    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(StartClass.class, args);
//        System.out.println(ctx.getBean("Clients", Clients.class));
        System.out.println("Hello world");
        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));

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
