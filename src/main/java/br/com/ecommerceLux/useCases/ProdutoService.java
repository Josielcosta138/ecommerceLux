package br.com.ecommerceLux.useCases;

import br.com.ecommerceLux.entitys.Produto;
import br.com.ecommerceLux.repositorys.ProdutoRepository;
import br.com.ecommerceLux.useCases.categoria.domains.Categoria;
import br.com.ecommerceLux.useCases.produto.domains.ProdutoResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoResponseDom> carregarProdutos() {

        List<Produto> listaDeProdutos = produtoRepository.findAll();
        List<ProdutoResponseDom> produtosDom = new ArrayList<>();

        for (Produto resultadoProdDom : listaDeProdutos){

            ProdutoResponseDom aux = new ProdutoResponseDom();
            aux.setId(resultadoProdDom.getId());
            aux.setNome(resultadoProdDom.getNome());
            aux.setPreco(resultadoProdDom.getPreco());
            aux.setCategoria(resultadoProdDom.getCategoria());
            produtosDom.add(aux);
        }
        return produtosDom;
    }


}
