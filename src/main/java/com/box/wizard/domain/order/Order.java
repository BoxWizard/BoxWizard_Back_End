package com.box.wizard.domain.order;

import com.box.wizard.domain.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Table(name="user_order")
public class Order extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "orderid",nullable = false, unique = true)
    private String orderID;

    @Column(name = "userid",nullable = false, unique = true)
    private String userID;

    @Column(name = "boxgrade",nullable = false)
    private String boxGrade;

    @Column(name = "boxprice",nullable = false)
    private String boxPrice;

    @Column(name = "productname")
    private String productName;

    @Column(name = "state",nullable = false, columnDefinition = "varchar(255) default '구매완료'")
    private String state;

//    @PrePersist
//    public void generateOrderId() {
//        // Order ID 생성 로직
//        String currentDate = "P" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        int nextId = getNextOrderID(); // 다음 ID를 가져오는 로직 (예: 데이터베이스 조회)
//        this.orderID = currentDate + "-" + nextId;
//    }
}
