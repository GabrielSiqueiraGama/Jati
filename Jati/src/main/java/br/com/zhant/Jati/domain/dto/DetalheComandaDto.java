package br.com.zhant.Jati.domain.dto;

import br.com.zhant.Jati.domain.comanda.Comanda;
import br.com.zhant.Jati.domain.usuario.Usuario;

public record DetalheComandaDto(Long id, Usuario usuario, Boolean aberta) {
    public DetalheComandaDto(Comanda comanda){
        this(comanda.getId(), comanda.getUsuario(), comanda.isAberta());
    }
}
