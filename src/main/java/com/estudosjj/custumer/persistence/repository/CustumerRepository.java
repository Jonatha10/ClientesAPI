package com.estudosjj.custumer.persistence.repository;

import com.estudosjj.custumer.persistence.entity.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// Vai ser injetado
public interface CustumerRepository extends JpaRepository<Custumer, Long> {

}
