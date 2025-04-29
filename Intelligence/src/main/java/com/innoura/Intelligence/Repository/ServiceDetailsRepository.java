package com.innoura.Intelligence.Repository;

import com.innoura.Intelligence.Entity.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails,Long>
{
    List<ServiceDetails> findByUserName(String userName);
}
