package com.estudosjj.custumer.ws.v1;

import com.estudosjj.custumer.model.request.CustumerRequest;
import com.estudosjj.custumer.model.response.CustumerResponse;
import com.estudosjj.custumer.service.CustumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1")
public class CustumerController {

        public static final Logger LOGGER = LoggerFactory.getLogger(CustumerController.class);

        @Autowired
        private CustumerService custumerService;

        @PostMapping
        public ResponseEntity<CustumerResponse> create(@RequestBody CustumerRequest custumerRequest){
            LOGGER.info("Requisição recebida");
            return ResponseEntity.ok(custumerService.create(custumerRequest));
        }
        @GetMapping
        public ResponseEntity<Page<CustumerResponse>> getAll(Pageable pageable){
            LOGGER.info("Buscando os registros");
            Page<CustumerResponse> custumerResponses = custumerService.getAll(pageable);
            return ResponseEntity.ok(custumerResponses);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CustumerResponse> update(@PathVariable("id") Long id, @RequestBody  CustumerRequest custumerRequest){
            LOGGER.info("Iniciando a Atualização");
            Optional<CustumerResponse> update = custumerService.update(id, custumerRequest);
            if (!update.isPresent()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(update.get());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CustumerResponse> get(@PathVariable("id") Long id){
            LOGGER.info("Iniciando a busca pelo registro");
            Optional<CustumerResponse> custumerResponse = custumerService.get(id);
            if (!custumerResponse.isPresent()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(custumerResponse.get());
        }

        @DeleteMapping("/id")
        public ResponseEntity<Void> delete(@PathVariable("id") Long id){
            LOGGER.info("Iniciando a remoção do registro");
            if (custumerService.delete(id)){
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        }
}
