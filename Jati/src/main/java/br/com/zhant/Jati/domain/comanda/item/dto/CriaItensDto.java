package br.com.zhant.Jati.domain.comanda.item.dto;

import java.math.BigDecimal;

public record CriaItensDto(String nome, Integer quantidade, BigDecimal preco) {
}
