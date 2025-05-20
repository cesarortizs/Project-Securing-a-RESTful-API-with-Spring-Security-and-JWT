package com.activity.five.controllers;

import com.activity.five.services.SuperSecretInfoService;
import com.activity.five.models.SuperSecretInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class SuperSecretInfoController {

    @Autowired
    SuperSecretInfoService superSecretInfoService;

    @GetMapping("/super-secret-info")
    @PreAuthorize("hasRole('ADMIN')")
    public List<SuperSecretInfo> getAllSecretInfo()
    {
        return superSecretInfoService.getAllSecretInfo();
    }

    @PostMapping("/super-secret-info")
    @PreAuthorize("hasRole('ADMIN')")
    public void addNewSuperSecretInfo(@RequestBody SuperSecretInfo newSuperSecretInfo)
    {
        superSecretInfoService.addNewSuperSecretInfo(newSuperSecretInfo);
    }
}
