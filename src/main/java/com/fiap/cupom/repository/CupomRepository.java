package com.fiap.cupom.repository;

import com.fiap.cupom.Cupom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Integer> {
}
