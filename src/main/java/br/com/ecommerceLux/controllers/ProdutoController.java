package br.com.ecommerceLux.controllers;

import br.com.ecommerceLux.useCases.ProdutoService;
import br.com.ecommerceLux.useCases.produto.domains.ProdutoResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/ecommerce/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping("/carregar")
    public ResponseEntity<List<ProdutoResponseDom>> carregarProdutos() {

        try {
            List<ProdutoResponseDom> response = produtoService.carregarProdutos();

            int status = 200;
            if (response.isEmpty()) {
                status = 204;
            }
            return ResponseEntity.status(status).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

}
