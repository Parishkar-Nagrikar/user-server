package com.mojos.userservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddressRequest{
    @Getter
    @Setter
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
