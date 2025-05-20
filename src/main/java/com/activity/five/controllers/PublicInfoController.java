package com.activity.five.controllers;

import com.activity.five.services.PublicInfoService;
import com.activity.five.models.PublicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class PublicInfoController {

    @Autowired
    PublicInfoService publicInfoService;

    @GetMapping("/public-info")
    public List<PublicInfo> getAllPublicInfo()
    {
        return publicInfoService.getAllPublicInfo();
    }

    @PostMapping("/public-info")
    public void addNewPublicInfo(@RequestBody PublicInfo newPublicInfo)
    {
        publicInfoService.addNewPublicInfo(newPublicInfo);
    }
}
