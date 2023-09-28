package com.estudosjj.custumer.service.mapper;

import com.estudosjj.custumer.model.response.CustumerResponse;
import com.estudosjj.custumer.persistence.entity.Custumer;
import org.springframework.stereotype.Component;

@Component
public class CusutumerResponseMapper implements Mapper<Custumer, CustumerResponse>{

    @Override
    public CustumerResponse map(Custumer input) {
        if(input==null){
            return null;
        }
        CustumerResponse custumerResponse= new CustumerResponse();
        custumerResponse.setId(input.getId());
        custumerResponse.setName(input.getName());
        custumerResponse.setDocument(input.getDocument());

        return custumerResponse;
    }


}
