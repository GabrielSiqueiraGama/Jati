package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.comanda.Comanda;
import br.com.zhant.Jati.domain.comanda.ComandaRepository;
import br.com.zhant.Jati.domain.dto.criaComandaDTO;
import br.com.zhant.Jati.domain.usuario.Usuario;
import br.com.zhant.Jati.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/comandas")
@RestController
public class ComandaController {

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;



    public ResponseEntity createComanda(@RequestBody() criaComandaDTO dados, UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        if (usuario == null){
            return ResponseEntity.badRequest().build();
        }

        Comanda comanda = new Comanda(usuario);

        var uri = uriBuilder.path("/comandas/{id}").buildAndExpand(comanda.getId()).toUri();

        comandaRepository.save(comanda);
        return ResponseEntity.created(uri).body(comanda);
    }
}