package com.hpdts.hello.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Accessors(chain = true)
public class Bank {

    @Id
    String id;
    String description;
}