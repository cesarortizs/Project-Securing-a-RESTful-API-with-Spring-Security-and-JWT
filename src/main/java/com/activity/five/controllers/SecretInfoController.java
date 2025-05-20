package com.activity.five.controllers;

import com.activity.five.services.SecretInfoService;
import com.activity.five.models.SecretInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class SecretInfoController {

    @Autowired
    SecretInfoService secretInfoService;

    @GetMapping("/secret-info")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<SecretInfo> getAllSecretInfo()
    {
        return secretInfoService.getAllSecretInfo();
    }

    @PostMapping("/secret-info")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void addNewSecretInfo(@RequestBody SecretInfo newSecretInfo)
    {
        secretInfoService.addNewSecretInfo(newSecretInfo);
    }
}
