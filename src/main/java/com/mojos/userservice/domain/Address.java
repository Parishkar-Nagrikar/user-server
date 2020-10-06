package com.mojos.userservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Address{

    @Getter
    @Setter
    private String street;

    @Getter @Setter
    private String areaCode;

    @Getter @Setter
    private String city;

    @Getter @Setter
    private String country;

    @Getter @Setter
    private String telPhoneNO;

}
