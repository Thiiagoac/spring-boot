package com.webstore.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webstore.cursomc.domain.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer>  {

}
