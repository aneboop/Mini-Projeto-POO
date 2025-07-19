package loja.model.nota;

import loja.model.cliente.Cliente; 
import loja.model.produto.Produto; 
import java.math.BigDecimal; 
import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.List; 

public class Nota {
    private String idNota;
    private LocalDateTime dataEmissao;
    private Cliente cliente;
    private Item[] itens; 
    private int numItens; 
    private BigDecimal valorTotal;

    private static final int max = 50; 

    public Nota(String idNota, Cliente cliente) {
        this.idNota = idNota;
        this.cliente = cliente;
        this.dataEmissao = LocalDateTime.now();
        this.itens = new Item[max]; 
        this.numItens = 0; 
        this.valorTotal = BigDecimal.ZERO;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (numItens >= max) {
            System.out.println("Erro: Limite máximo de itens na nota atingido (" + max + ").");
            return;
        }

        if (produto.getEstoque() >= quantidade) {
            Item item = new Item(produto, quantidade);
            this.itens[numItens] = item; 
            this.numItens++;
            this.valorTotal = this.valorTotal.add(item.getSubtotalItem());
            produto.setEstoque(produto.getEstoque() - quantidade);
        } else {
            System.out.println("Erro: Quantidade solicitada de " + produto.getNome() + " excede o estoque disponível (" + produto.getEstoque() + ").");
        }
    }

    public String getIdNota() {
        return idNota;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Retorna uma cópia do array de itens válidos para evitar manipulação externa direta
    public Item[] getItens() {
        Item[] itensValidos = new Item[numItens];
        System.arraycopy(itens, 0, itensValidos, 0, numItens);
        return itensValidos;
    }

    public int getNumItens() {
        return numItens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal calcularSubtotal() {
        return valorTotal;
    }

    public void exibirResumo() {
        System.out.println("\n--- Nota de Compra ---");
        System.out.println("ID da Nota: " + idNota);
        System.out.println("Data: " + dataEmissao.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("Cliente: " + cliente.getNome() + " (ID: " + cliente.getIdentificador() + ")");
        System.out.println("Itens:");
        for (int i = 0; i < numItens; i++) { 
            System.out.println(itens[i]);
        }
        System.out.println("----------------------");
        System.out.println("Valor Total: " + valorTotal);
        System.out.println("----------------------");
    }
    
}
