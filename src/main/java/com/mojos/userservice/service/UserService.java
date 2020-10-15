package com.mojos.userservice.service;

import com.mojos.userservice.domain.Address;
import com.mojos.userservice.domain.User;
import com.mojos.userservice.model.AddressRequest;
import com.mojos.userservice.model.AddressResponse;
import com.mojos.userservice.model.UserRequest;
import com.mojos.userservice.model.UserResponse;
import com.mojos.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    //INSTANCE;

    @Autowired
    UserRepository userRepository;

    public UserResponse crete(UserRequest userRequest){

        User newUser = null;
        try {
            newUser = userRerquestMapper(userRequest);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
         try {
             newUser = userRepository.save(newUser);
         }catch (Exception e){
             System.out.println(e.fillInStackTrace());
         }

        return userResponseMapper(newUser);
    }
//model(request) to domain
    private User userRerquestMapper(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        user.setAddress(addressRequestMapper(userRequest.getAddressRequest()));
        return user;
    }
//model(request) to domain
    private Address addressRequestMapper(AddressRequest req) {
        Address address  = new Address();
        address.setAreaCode(req.getAreaCode());
        address.setCity(req.getCity());
        address.setCountry(req.getCountry());
        address.setStreet(req.getStreet());
        address.setTelPhoneNO(req.getTelPhoneNO());
        return address;
    }

    public Optional<UserResponse> get(String id) {
        Optional<User> user = userRepository.findByUserId(id);
        if(user.isPresent()) {
            return Optional.of(userResponseMapper(user.get()));
        }else {
            return Optional.empty();
        }
    }

    public Optional<UserResponse> getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            return Optional.of(userResponseMapper(user.get()));
        }else {
            return Optional.empty();
        }
    }

//domain to model(response)
    private UserResponse userResponseMapper(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        userResponse.setAddressResponse(addressResponseMapper(user.getAddress()));
        return userResponse;

    }
//domain to model(response)
    private AddressResponse addressResponseMapper(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAreaCode(address.getAreaCode());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setTelPhoneNO(address.getTelPhoneNO());
        return addressResponse;
    }

    public UserResponse update(UserRequest userRequest) {
        Optional<User> userToUpdate = userRepository.findByEmail(userRequest.getEmail());
        if (userToUpdate.isPresent()){
            userRepository.delete(userToUpdate.get());
            userToUpdate.get().setName(userRequest.getName());
            userToUpdate.get().setRole(userRequest.getRole());
            userToUpdate.get().setAddress(addressRequestMapper(userRequest.getAddressRequest()));

            return userResponseMapper(userRepository.save(userToUpdate.get()));
        }else{
            return crete(userRequest);
        }
    }

    public void delete(String userId) {
        System.out.println(" uid :" +get(userId));
        try{
            userRepository.deleteByUserId(userId);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}