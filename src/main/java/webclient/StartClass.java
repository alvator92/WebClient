package webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.ComponentScan;
import webclient.backend.common.Common;
import webclient.backend.common.Utils;
import webclient.backend.configuration.db.hibernate.HibernateConfig;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages ="webclient.*")
public class StartClass implements CommandLineRunner {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateConfig hibernateConfig;
    public static void main(String[] args) {

        SpringApplication.run(StartClass.class, args);
        System.out.println("Hello world");

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataSource : " + hibernateConfig);

        Iterator hmIterator = jpaProperties.getProperties().entrySet().iterator();

        while (hmIterator.hasNext()) {
            Map.Entry mapElement
                    = (Map.Entry)hmIterator.next();
            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
        }
    }
}
