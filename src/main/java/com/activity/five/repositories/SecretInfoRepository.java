package com.activity.five.repositories;

import com.activity.five.models.SecretInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretInfoRepository extends JpaRepository<SecretInfo, Integer> {
}
