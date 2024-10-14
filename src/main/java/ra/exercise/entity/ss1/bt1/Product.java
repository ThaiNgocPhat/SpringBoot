package ra.exercise.entity.ss1.bt1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private double productPrice;
    private int productStock;
    private LocalDate created;
    private boolean status;

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
    }
}
