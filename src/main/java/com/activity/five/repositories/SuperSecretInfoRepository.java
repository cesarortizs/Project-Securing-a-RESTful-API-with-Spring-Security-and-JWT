package com.activity.five.repositories;

import com.activity.five.models.SuperSecretInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperSecretInfoRepository extends JpaRepository<SuperSecretInfo, Integer> {
}
