package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.persistence.UserEntity;
import com.example.backend.persistence.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity getUserById(Integer id) {
        return userRepository.getUserEntitiesById(id);
    }
    public List<UserEntity> getAllUsers(){
       return userRepository.findAll();
    }

    public Optional<UserEntity> insertNewUser(HttpEntity<String> user){
        Optional<UserEntity> insertedUser = Optional.empty();

        //Json input from body is turned into a user model
        Optional<User> userFromHttpBody = jsonToUserModel(user.getBody());

        //TODO Check if data is actually valid
        if(userFromHttpBody.isPresent()){
            UserEntity newUser = userEntityMapper(userFromHttpBody.get());
            UserEntity returnedUser = userRepository.save(newUser);
            insertedUser = Optional.of(returnedUser);
        }

        return insertedUser;
    }

    private UserEntity userEntityMapper(User user){
        return new UserEntity(user.getTipo(),user.getNumdoc(),user.getNombre(),user.getSegundo_nombre(),user.getApellidos(),user.getF_nacimiento(),user.getGenero(),user.getCorreo(),user.getCelular(),user.getFoto());
    }

    private Optional<User> jsonToUserModel(String jsonUser){
        ObjectMapper mapper = new ObjectMapper();
        Optional<User> user = Optional.empty();
        try {
            User mappedUser = mapper.readValue(jsonUser, User.class);
            user = Optional.of(mappedUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Optional<UserEntity> updateUser(Integer id, HttpEntity<String> user) {
        Optional<UserEntity> updatedUser = Optional.empty();
        Optional<UserEntity> oldUser = Optional.ofNullable(userRepository.getUserEntityById(id));

        if(oldUser.isEmpty()){
            return updatedUser;
        }

        Optional<User> userFromHttpBody = jsonToUserModel(user.getBody());

        //TODO Check if data is actually valid
        if(userFromHttpBody.isPresent()){
            UserEntity userToBeUpdated = updateUser(userFromHttpBody.get(), oldUser.get());
            UserEntity returnedUser = userRepository.save(userToBeUpdated);
            updatedUser = Optional.of(returnedUser);
        }
        return updatedUser;
    }
    private UserEntity updateUser(User newUserInformation, UserEntity user){
        if(newUserInformation.getNombre() != null){
            user.setNombre(newUserInformation.getNombre());
        }
        if(newUserInformation.getSegundo_nombre() != null){
            user.setSegundo_nombre(newUserInformation.getSegundo_nombre());
        }
        if(newUserInformation.getApellidos() != null){
            user.setApellidos(newUserInformation.getApellidos());
        }
        if(newUserInformation.getF_nacimiento() != null){
            user.setF_nacimiento(newUserInformation.getF_nacimiento());
        }
        if(newUserInformation.getGenero() != null){
            user.setGenero(newUserInformation.getGenero());
        }

        if(newUserInformation.getCorreo() != null){
            user.setCorreo(newUserInformation.getCorreo());
        }

        if(newUserInformation.getCelular() != null){
            user.setCelular(newUserInformation.getCelular());
        }

        if(newUserInformation.getFoto() != null){
            user.setFoto(newUserInformation.getFoto());
        }

        return user;
    }



}
