package webclient.backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "product_code", nullable = false)
    private String product_code;

    @Column(name = "name_of_product", nullable = false)
    private String name_of_product;

    @Column(name = "product_category", nullable = false)
    private Integer product_category;

    @Column(name = "container", nullable = false)
    private String container;

    @Column(name = "stop_list", nullable = false)
    private Boolean stop_list;

//    @DateTimeFormat(pattern = "yyyy.MM.dd HH-mm")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH-mm")
    @Column(name = "shelf_life", columnDefinition = "DATETIME", nullable = false)
    private Date shelf_life;


}
