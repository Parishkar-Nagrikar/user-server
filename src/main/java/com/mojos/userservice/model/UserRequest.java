package com.mojos.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mojos.userservice.domain.Address;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequest {

    @Getter@Setter
    String name;

    @Getter@Setter
    String email;

    @Getter@Setter
    @JsonProperty("address")
    AddressRequest addressRequest;

    @Getter@Setter
    String role;
}
