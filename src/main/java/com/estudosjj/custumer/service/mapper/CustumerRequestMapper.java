package com.estudosjj.custumer.service.mapper;

import com.estudosjj.custumer.model.request.CustumerRequest;
import com.estudosjj.custumer.persistence.entity.Custumer;
import org.springframework.stereotype.Component;

@Component
public class CustumerRequestMapper implements Mapper<CustumerRequest, Custumer>{
    @Override
    public Custumer map(CustumerRequest input) {
        if (input == null) {
            return null;
        }

        Custumer custumer = new Custumer();
        custumer.setName(input.getName());
        custumer.setDocument(input.getDocument());

        return custumer;
    }
}
