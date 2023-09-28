package com.estudosjj.custumer.service;

import com.estudosjj.custumer.model.request.CustumerRequest;
import com.estudosjj.custumer.model.response.CustumerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CustumerService {
    CustumerResponse create(CustumerRequest custumerRequest);
    Page<CustumerResponse> getAll(Pageable pageable);
    Optional<CustumerResponse > update(Long id, CustumerRequest custumerRequest);
    Optional<CustumerResponse> get(Long id);
    boolean delete(Long id);
}
