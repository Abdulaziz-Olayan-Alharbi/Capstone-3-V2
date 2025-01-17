package com.example.capstone_3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^(Pending|Confirmed|Processing in Merchant| Processing in Tailor | Processing in Designer | Reject By Mercahnt | Reject By Tailor , Reject By Designer | Shipped | Delivered )$")
    @Column(columnDefinition = "varchar(25) not null")
    private String orderStatus;
    @PositiveOrZero
    @Column(columnDefinition = "double")
    private double totalPrice;
    @Column(columnDefinition = "datetime")
    private LocalDateTime orderDate = LocalDateTime.now();
    @Column(columnDefinition = "datetime")
    private LocalDateTime deliveryDate;
    @ManyToOne
    @JsonIgnore
    private Customer custom;
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Shipping shipping;

}
