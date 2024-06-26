package br.com.ecommerceLux.controllers;


import br.com.ecommerceLux.useCases.ClienteService;
import br.com.ecommerceLux.useCases.EnderecoService;
import br.com.ecommerceLux.useCases.endereco.domains.EnderecoRequestDom;
import br.com.ecommerceLux.useCases.endereco.domains.EnderecoResponseDom;
import br.com.ecommerceLux.utils.CrudException;
import br.com.ecommerceLux.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/ecommerce/enderecos")
public class EnderecoController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/carregar")
    public ResponseEntity<List<EnderecoResponseDom>> carregarEnderecos(){
        try {
            List<EnderecoResponseDom> response = enderecoService.carregarEnderecos();
            int status = 200;
            if (response.isEmpty()){
                status = 204;
            }
            return ResponseEntity
                        .status(status)
                        .body(response);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                        .badRequest()
                        .body(null);
        }
    }

    @GetMapping("/carregar/{id}")
    public ResponseEntity<EnderecoResponseDom> carregarEnderecosById(@PathVariable Long id){

        try {
            EnderecoResponseDom responseDOM = enderecoService.carregarEnderecosById(id);

            if (responseDOM != null){
                return ResponseEntity.ok(responseDOM);
            }
            return ResponseEntity
                        .status(204)
                        .body(null);
        }
        catch (Exception e){
            e.printStackTrace();

            return ResponseEntity
                        .badRequest()
                        .body(null);
        }
    }

    @GetMapping("/carregaEnderecosIdCliente/{id}")
    public ResponseEntity<List<EnderecoResponseDom>> carregarEnderecosByIdCliente(@PathVariable Long id){

        try {
            List<EnderecoResponseDom> responseDOM = enderecoService.carregarEnderecosByIdCliente(id);
            int status = 200;

                if (responseDOM.isEmpty()){
                    status = 204;
                }
            return ResponseEntity.status(status).body(responseDOM);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }



    @CrossOrigin
    @PostMapping("/criar")
    public ResponseEntity<?> criarEndereco(@RequestBody EnderecoRequestDom endereco){
        try {
            EnderecoResponseDom responseDOM = enderecoService.criarEndereco(endereco);
            return ResponseEntity.status(201).body(responseDOM);
        }
        catch (CrudException es){
            es.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(es.getMessages()));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado"+ e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EnderecoResponseDom> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDom endereco){
        try {
            EnderecoResponseDom responseDOM = enderecoService.atualizarEndereco(id, endereco);
            if (responseDOM == null){
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(responseDOM);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable Long id){
        try {
            enderecoService.excluirEndereco(id);
            return ResponseEntity.ok(null);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

}
