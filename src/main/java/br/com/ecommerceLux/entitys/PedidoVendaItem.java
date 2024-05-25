package br.com.ecommerceLux.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PedidoVendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pedidoVendaItem")
    List<PedidoVenda> pedidoVendas;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double preco;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PedidoVenda> getPedidoVendas() {
        return pedidoVendas;
    }

    public void setPedidoVendas(List<PedidoVenda> pedidoVendas) {
        this.pedidoVendas = pedidoVendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
