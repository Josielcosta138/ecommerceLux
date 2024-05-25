package br.com.ecommerceLux.entitys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PedidoVenda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPedido;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private Double totalPedido;

    @ManyToOne
    @JoinColumn(name = "clientes_id", nullable = false)
    private Clientes clientes;

    @OneToMany(mappedBy = "pedidoVenda")
    List<Pagamento> pagamentos;

    @ManyToOne
    @JoinColumn(name = "pedido_venda_item_id", nullable = false)
    private PedidoVendaItem pedidoVendaItem;


    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public PedidoVendaItem getPedidoVendaItem() {
        return pedidoVendaItem;
    }

    public void setPedidoVendaItem(PedidoVendaItem pedidoVendaItem) {
        this.pedidoVendaItem = pedidoVendaItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
