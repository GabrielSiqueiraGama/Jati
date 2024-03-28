package br.com.zhant.Jati.domain.dto;

import br.com.zhant.Jati.domain.comanda.Comanda;
import br.com.zhant.Jati.domain.comanda.item.Item;
import br.com.zhant.Jati.domain.comanda.item.dto.DetalheItemDto;
import br.com.zhant.Jati.domain.usuario.Usuario;

import java.util.List;
import java.util.stream.Stream;

public record DetalheComandaDto(Long id, Usuario usuario, Boolean aberta, Stream<DetalheItemDto> itens) {
    public DetalheComandaDto(Comanda comanda, List<Item> itens){
        this(comanda.getId(), comanda.getUsuario(), comanda.isAberta(), itens.stream().map(DetalheItemDto::new));
    }
    public DetalheComandaDto(Comanda comanda){
        this(comanda.getId(), comanda.getUsuario(), comanda.isAberta(), comanda.getItens().stream().map(DetalheItemDto:: new));
    }
}
