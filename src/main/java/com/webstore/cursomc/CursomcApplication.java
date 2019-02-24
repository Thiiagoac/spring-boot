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
	@Autowired
	private PedidoRepository pedirepo;
	@Autowired
	private PagamentoRepository pagrepo;
	@Autowired
	private ItemPedidoRepository itemrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"ainformatica");
		Categoria cat2 = new Categoria(null,"bescritorio");
		Categoria cat3 = new Categoria(null,"cinformaticaaa");
		Categoria cat4 = new Categoria(null,"descritorio22");
		Categoria cat5 = new Categoria(null,"einformaticad");
		Categoria cat6 = new Categoria(null,"fescritoriossd");
		Categoria cat7 = new Categoria(null,"ginformaticafq");
		
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 10:32"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		
		
		
		
		catrepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		prodrepo.saveAll(Arrays.asList(p1,p2,p3));
		estrepo.saveAll(Arrays.asList(est1,est2));
		cidrepo.saveAll(Arrays.asList(c1,c2,c3));
		clirepo.saveAll(Arrays.asList(cli1));
		endrepo.saveAll(Arrays.asList(e1,e2));
		pedirepo.saveAll(Arrays.asList(ped1,ped2));
		pagrepo.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		itemrepo.saveAll(Arrays.asList(ip1,ip2,ip3));
	
	}
	
	
 
}
