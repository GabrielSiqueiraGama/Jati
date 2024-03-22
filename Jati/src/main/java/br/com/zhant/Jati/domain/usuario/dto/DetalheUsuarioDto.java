package br.com.zhant.Jati.domain.usuario.dto;

import br.com.zhant.Jati.domain.usuario.Usuario;

public record DetalheUsuarioDto(String nome, String telefone, String email) {
    public DetalheUsuarioDto(Usuario usarioEncontrado){
        this(usarioEncontrado.getNome(), usarioEncontrado.getTelefone(), usarioEncontrado.getEmail());
    }
}
