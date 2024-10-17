package ra.exercise.entity.ss4.bt4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees3")
public class Employee3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String fullName;
    private String address;
    private String phone;
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department1 department;
}
