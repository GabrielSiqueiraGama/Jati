package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.usuario.Usuario;
import br.com.zhant.Jati.domain.usuario.UsuarioRepository;
import br.com.zhant.Jati.domain.usuario.dto.CriaUsuarioDto;
import br.com.zhant.Jati.domain.usuario.dto.DetalheUsuarioDto;
import br.com.zhant.Jati.domain.usuario.dto.EditarUsuarioDto;
import org.springframework.transaction.annotation.Transactional;
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarUsuaio(@PathVariable Long id, @RequestBody() EditarUsuarioDto dados){
        var usuarioEncontrado = repository.getReferenceById(id);
        if(usuarioEncontrado == null){
            ResponseEntity.notFound().build();
        }

        usuarioEncontrado.update(dados);

        return ResponseEntity.ok(new DetalheUsuarioDto(usuarioEncontrado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUsuario(@PathVariable Long id){
        var usuarioEncontrado = repository.getReferenceById(id);

        if(usuarioEncontrado == null){
            ResponseEntity.notFound().build();
        }

        repository.delete(usuarioEncontrado);
        return ResponseEntity.noContent().build();
    }
}
