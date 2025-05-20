package com.activity.five.services;

import com.activity.five.models.SecretInfo;
import com.activity.five.repositories.SecretInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SecretInfoService {

    @Autowired
    SecretInfoRepository secretInfoRepository;

    public List<SecretInfo> getAllSecretInfo()
    {
        List<SecretInfo> allSecretInfo = secretInfoRepository.findAll();

        return allSecretInfo;
    }

    public void addNewSecretInfo(@RequestBody SecretInfo newSecretInfo)
    {
        secretInfoRepository.save(newSecretInfo);
    }
}
