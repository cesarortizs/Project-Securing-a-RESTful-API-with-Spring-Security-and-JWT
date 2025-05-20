package com.activity.five.services;

import com.activity.five.models.SuperSecretInfo;
import com.activity.five.repositories.SuperSecretInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SuperSecretInfoService {

    @Autowired
    SuperSecretInfoRepository superSecretInfoRepository;

    public List<SuperSecretInfo> getAllSecretInfo()
    {
        List<SuperSecretInfo> allSuperSecretInfo = superSecretInfoRepository.findAll();

        return allSuperSecretInfo;
    }

    public void addNewSuperSecretInfo(@RequestBody SuperSecretInfo newSuperSecretInfo)
    {
        superSecretInfoRepository.save(newSuperSecretInfo);
    }
}
