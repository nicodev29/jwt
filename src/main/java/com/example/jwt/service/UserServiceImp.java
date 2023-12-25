package com.example.jwt.service;


import com.example.jwt.constantes.FacturaConstante;
import com.example.jwt.dao.UserDAO;
import com.example.jwt.model.User;
import com.example.jwt.utils.FacturaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        log.info("Registro interno", requestMap);
        try {
            if (!validateSignUpMap(requestMap)) {
                return FacturaUtils.getResponseEntity("Datos invalidos", HttpStatus.BAD_REQUEST);
            }
            User user = userDAO.findByEmail(requestMap.get("email"));
            if (Objects.isNull(user)) {
                userDAO.save(getUserFromMap(requestMap));
                return FacturaUtils.getResponseEntity("Usuario Registrado", HttpStatus.CREATED);
            }
            return FacturaUtils.getResponseEntity("Email registrado", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FacturaUtils.getResponseEntity(FacturaConstante.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateSignUpMap(Map<String, String> requestMap) {

        return requestMap.containsKey("nombre")
                && requestMap.containsKey("numeroDeContacto")
                && requestMap.containsKey("email")
                && requestMap.containsKey("password");
    }

    private User getUserFromMap(Map<String, String> requestMap) {

        User user = new User();
        user.setName(requestMap.get("nombre"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setNumeroContacto(requestMap.get("numeroDeContacto"));
        user.setRole("user");

        return user;

    }

}
