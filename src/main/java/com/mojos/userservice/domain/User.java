package com.mojos.userservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Data
@Document("user")
@CrossOrigin
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    @Getter @Setter
    private String userId = UUID.randomUUID().toString();

    @Getter @Setter
    private String name;

    @Indexed(unique = true)
    @Getter @Setter
    private String email;

    @Getter @Setter
    private Address address;

    @Getter @Setter
    private String role;
}
