package com.webstore.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webstore.cursomc.domain.Categoria;
import com.webstore.cursomc.domain.Cidade;
import com.webstore.cursomc.domain.Cliente;
import com.webstore.cursomc.domain.Endereco;
import com.webstore.cursomc.domain.Estado;
import com.webstore.cursomc.domain.ItemPedido;
import com.webstore.cursomc.domain.Pagamento;
import com.webstore.cursomc.domain.PagamentoComBoleto;
import com.webstore.cursomc.domain.PagamentoComCartao;
import com.webstore.cursomc.domain.Pedido;
import com.webstore.cursomc.domain.Produto;
import com.webstore.cursomc.domain.enums.EstadoPagamento;
import com.webstore.cursomc.domain.enums.TipoCliente;
import com.webstore.cursomc.repositories.CategoriaRepository;
import com.webstore.cursomc.repositories.CidadeRepository;
import com.webstore.cursomc.repositories.ClienteRepository;
import com.webstore.cursomc.repositories.EnderecoRepository;
import com.webstore.cursomc.repositories.EstadoRepository;
import com.webstore.cursomc.repositories.ItemPedidoRepository;
import com.webstore.cursomc.repositories.PagamentoRepository;
import com.webstore.cursomc.repositories.PedidoRepository;
import com.webstore.cursomc.repositories.ProdutoRepository;

/*
 * 
 *ordem de criação
 *
 * 1° DOMAIN
 * 2° REPOSITORY
 * 3° SERVICES
 * 4° RESOURCES
 * 
 * */
 


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
 
}
