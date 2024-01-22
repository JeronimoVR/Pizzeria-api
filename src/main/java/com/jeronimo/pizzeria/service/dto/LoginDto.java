package com.jeronimo.pizzeria.service.dto;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class LoginDto {

   private String username;
   private String password;

}
