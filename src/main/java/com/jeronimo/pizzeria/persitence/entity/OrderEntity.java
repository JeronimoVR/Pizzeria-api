package com.jeronimo.pizzeria.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "Decimal(6,2)")
    private Double total;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "additional_notes", length = 200)
    private String addtionalNotes;

    //Relaciones de la tabla

    @OneToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "id_customer",insertable = false,updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;


}