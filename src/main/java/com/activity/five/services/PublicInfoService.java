package com.activity.five.services;

import com.activity.five.models.PublicInfo;
import com.activity.five.repositories.PublicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PublicInfoService {

    @Autowired
    PublicInfoRepository publicInfoRepository;

    public List<PublicInfo> getAllPublicInfo()
    {
        List<PublicInfo> allPublicInfo = publicInfoRepository.findAll();

        return allPublicInfo;
    }

    public void addNewPublicInfo(@RequestBody PublicInfo newPublicInfo)
    {
        publicInfoRepository.save(newPublicInfo);
    }
}
