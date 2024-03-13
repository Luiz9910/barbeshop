package com.barbearia.barbearia.controller;

import com.barbearia.barbearia.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("barbeshop")
public class BarbeshopController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBarbeShop(){

    }
}
