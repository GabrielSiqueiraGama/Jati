package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.usuario.Usuario;
import br.com.zhant.Jati.domain.usuario.UsuarioRepository;
import br.com.zhant.Jati.domain.usuario.dto.CriaUsuarioDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createUsuaio(@RequestBody() CriaUsuarioDto dados){
        Usuario usuario = new Usuario(dados);
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity getUsuarios(){
        var usuarios = repository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
