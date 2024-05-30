package br.com.ecommerceLux.useCases;

import br.com.ecommerceLux.entitys.Produto;
import br.com.ecommerceLux.repositorys.ProdutoRepository;
import br.com.ecommerceLux.useCases.produto.domains.ProdutoResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoResponseDom> carregarProdutos() {

        return null;
    }


}
