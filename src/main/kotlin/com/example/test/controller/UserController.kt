package com.example.test.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping("/checking")
    fun getUser() : ResponseEntity<String> {
        return ResponseEntity.ok("성공")
    }

    @GetMapping("/checking/list")
    fun getUserList() : ResponseEntity<String> {
        return ResponseEntity.ok("성공")
    }

    @PostMapping("/checking/list")
    fun setUserList() : ResponseEntity<String> {
        return ResponseEntity.ok("성공")
    }
    
}