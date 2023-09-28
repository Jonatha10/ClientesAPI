package com.estudosjj.custumer.service;

import com.estudosjj.custumer.model.request.CustumerRequest;
import com.estudosjj.custumer.model.response.CustumerResponse;
import com.estudosjj.custumer.persistence.entity.Custumer;
import com.estudosjj.custumer.persistence.repository.CustumerRepository;
import com.estudosjj.custumer.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CostumerServiceImpl implements CustumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustumerService.class);

    @Autowired
    private CustumerRepository custumerRepository;

    @Autowired
    private Mapper<CustumerRequest, Custumer> requestMapper;

    @Autowired
    private Mapper<Custumer, CustumerResponse> responseMapper;

    @Override
    public CustumerResponse create(CustumerRequest custumerRequest) {
        LOGGER.info("Criando um registro do Cliente");
        Assert.notNull(custumerRequest, "Request Invalida");
        Custumer custumer = this.requestMapper.map(custumerRequest);
        return custumerRepository.saveAndFlush(custumer).map((Custumer input) -> this.responseMapper.map(custumer));

    }

    @Override
    public Page<CustumerResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os registros");
        Assert.notNull(pageable, "Página Invalida");
        return custumerRepository.findAll(pageable).map(custumer -> this.responseMapper.map(custumer));
    }

    @Override
    public Optional<CustumerResponse> update(Long id, CustumerRequest custumerRequest) {
        LOGGER.info("Atualizando um registro");
        Assert.notNull(id, "Id Invalida");

        Custumer custumerUpdate = this.requestMapper.map(custumerRequest);//

        return custumerRepository.findById(id)
                .map(custumer -> {

                    custumer.setName(custumerUpdate.getName());
                    return this.responseMapper.map(custumerRepository.saveAndFlush(custumer));
                });

    }

    @Override
    public Optional<CustumerResponse> get(Long id) {
        LOGGER.info("Buscando registro");
        Assert.notNull(id, "ID inválido");
        return custumerRepository.findById(id).map(this.responseMapper::map);
    }


    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo registro");
        Assert.notNull(id, "ID inválido");

        try {
            custumerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover o registro {}", id);
        }
        return false;
    }

}
