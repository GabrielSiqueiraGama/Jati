package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.comanda.Comanda;
import br.com.zhant.Jati.domain.comanda.ComandaRepository;
import br.com.zhant.Jati.domain.dto.DetalheComandaDto;
import br.com.zhant.Jati.domain.dto.criaComandaDTO;
import br.com.zhant.Jati.domain.dto.editarComandaDto;
import br.com.zhant.Jati.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;



    @PostMapping
    @Transactional
    public ResponseEntity createComanda(@RequestBody() criaComandaDTO dados, UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());

        if (usuario == null){
            return ResponseEntity.badRequest().build();
        }

        Comanda comanda = new Comanda(usuario);
        comandaRepository.save(comanda);
        var uri = uriBuilder.path("/comandas/{id}").buildAndExpand(comanda.getId()).toUri();


        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getComandaById(@PathVariable Long id){
        var comanda = comandaRepository.getReferenceById(id);

        if(comanda == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DetalheComandaDto(comanda));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarComanda(@PathVariable Long id, @RequestBody editarComandaDto dados){
        var comanda = comandaRepository.getReferenceById(id);

        if (comanda == null){
            ResponseEntity.notFound().build();
        }

        comanda.update(dados);

        return ResponseEntity.ok(new DetalheComandaDto(comanda));

    }

    @GetMapping()
    @Transactional()
    public ResponseEntity getAllComandas(){
        var comandas = comandaRepository.findAllByAbertaTrue();
        var comandasDetalhadas = comandas.stream().map(DetalheComandaDto::new);
        return ResponseEntity.ok(comandasDetalhadas);
    }
}
