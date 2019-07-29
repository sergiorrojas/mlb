package com.sergiroj.mlb.controller;

import com.sergiroj.mlb.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PlayerController {
    @Autowired
    PlayerService playerService;
}
