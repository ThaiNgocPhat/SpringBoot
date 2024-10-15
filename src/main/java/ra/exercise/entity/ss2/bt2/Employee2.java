package ra.exercise.entity.ss2.bt2;

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
@Table(name = "employee2")
public class Employee2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String fullName;
    private String address;
    private String phone;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
