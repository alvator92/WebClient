package webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import webclient.backend.configuration.db.hibernate.HibernateConfig;

import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
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
            int marks = ((int)mapElement.getValue() + 10);

            // Printing mark corresponding to string entries
            System.out.println(mapElement.getKey() + " : "
                    + marks);
        }
    }
}
