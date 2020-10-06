package com.mojos.userservice.model;

import lombok.Getter;
import lombok.Setter;

public class AddressResponse {
    @Getter@Setter
    String street;
    @Getter@Setter
    String areaCode;
    @Getter@Setter
    String city;
    @Getter@Setter
    String country;
    @Getter@Setter
    String telPhoneNO;
}