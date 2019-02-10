package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.cursomc.domain.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer>  {

}
