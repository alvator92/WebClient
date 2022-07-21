package webclient.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Clients", schema = "public")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "product_code", nullable = false)
    private String product_code;

    @Column(name = "name_of_product", nullable = false)
    private String name_of_product;

}
