package com.webstore.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DBService {

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
	
	public void instantiateTestDatabase() throws ParseException {
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
		Produto p4 = new Produto(null,"mesa de escritorio",300.00);
		Produto p5 = new Produto(null,"toalha",50.0);
		Produto p6 = new Produto(null,"colcha",200.0);
		Produto p7 = new Produto(null,"tv true color",1200.00);
		Produto p8 = new Produto(null,"roçadeira",800.0);
		Produto p9 = new Produto(null,"abajour",100.0);
		Produto p10 = new Produto(null,"pendente",180.00);
		Produto p11 = new Produto(null,"shampoo",90.0);
		
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
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
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
		prodrepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
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
