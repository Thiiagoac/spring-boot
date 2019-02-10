package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

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
	@Autowired
	private CategoriaRepository catrepo;
	@Autowired
	private ProdutoRepository prodrepo;
	@Autowired 
	private EstadoRepository estrepo;
	@Autowired
	private CidadeRepository cidrepo;
	@Autowired
	private EnderecoRepository endrepo;
	@Autowired
	private ClienteRepository clirepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"informatica");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.0);
		Produto p3 = new Produto(null,"mouse",80.0);
		
		Estado est1 = new Estado(null,"Minas");
		Estado est2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade(null,"uberlandia",est1);
		Cidade c2 = new Cidade(null,"saopaulo",est2);
		Cidade c3 = new Cidade(null,"campinas",est2);
		
		Cliente cli1 = new Cliente (null,"Maria Silva","maria@gmail.com","363544895", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "9484822"));
		
		Endereco e1 = new Endereco(null, "rua flores", "300", "apt 203", "jardim" , "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "avenida matos", "105", "sala 800", "centro" , "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		
		
		catrepo.saveAll(Arrays.asList(cat1,cat2));
		prodrepo.saveAll(Arrays.asList(p1,p2,p3));
		estrepo.saveAll(Arrays.asList(est1,est2));
		cidrepo.saveAll(Arrays.asList(c1,c2,c3));
		clirepo.saveAll(Arrays.asList(cli1));
		endrepo.saveAll(Arrays.asList(e1,e2));
	
	}
	
	
 
}
