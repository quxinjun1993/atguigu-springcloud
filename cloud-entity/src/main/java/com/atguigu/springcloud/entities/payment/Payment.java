package com.atguigu.springcloud.entities.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    //使用通用mapper  这个注解一定要加   不然一些方法无法使用
    @Id
    private Long id;
    private String serial;
}
