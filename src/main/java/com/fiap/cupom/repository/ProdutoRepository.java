package com.fiap.cupom.repository;

import com.fiap.cupom.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
