package br.com.zhant.Jati.domain.comanda.item.dto;

import br.com.zhant.Jati.domain.comanda.item.Item;

import java.math.BigDecimal;

public record DetalheItemDto(Long id, String nome, Integer quantidade, BigDecimal preco, BigDecimal totalItem) {
    public DetalheItemDto(Item item){
        this(item.getId(), item.getNome(), item.getQuantidade(), item.getPreco(), (item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()))));
    }
}
