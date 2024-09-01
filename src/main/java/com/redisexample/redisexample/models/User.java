package com.redisexample.redisexample.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private String userId;
    private String name;
    private String phoneNumber;
    private String email;
}
