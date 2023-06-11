package com.testJPA.testJPA.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString(exclude = {"department"})
@EqualsAndHashCode(of = "id")
@Table(name="tbl_emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;

    @Column(name="emp_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "dept_id")
    private Department department;
}
