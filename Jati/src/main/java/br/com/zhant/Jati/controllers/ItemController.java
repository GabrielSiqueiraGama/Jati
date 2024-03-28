package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.comanda.ComandaRepository;
import br.com.zhant.Jati.domain.comanda.item.ItemRepository;
import br.com.zhant.Jati.domain.comanda.item.dto.DetalheItemDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comandas")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ComandaRepository comandaRepository;

    @GetMapping("/{id}/itens")
    @Transactional
    public ResponseEntity getAllItens(@PathVariable Long id){
        var itens = itemRepository.findAllByComandaId(id).stream().map(DetalheItemDto::new);
        return ResponseEntity.ok(itens);

    }
}
