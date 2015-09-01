package com.hpdts.hello.domain;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Setter
@Accessors(chain = true)
public class Bank {

    @Id
    String id;
    String description;
}