package br.com.zhant.Jati.controllers;

import br.com.zhant.Jati.domain.comanda.ComandaRepository;
import br.com.zhant.Jati.domain.comanda.item.Item;
import br.com.zhant.Jati.domain.comanda.item.ItemRepository;
import br.com.zhant.Jati.domain.comanda.item.dto.CriaItensDto;
import br.com.zhant.Jati.domain.comanda.item.dto.DetalheItemDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("/{id}/itens")
    @Transactional
    public ResponseEntity createItens(@PathVariable Long id, @RequestBody CriaItensDto dados, UriComponentsBuilder uriBuilder){
        var comanda = comandaRepository.getReferenceById(id);
        if(comanda == null){
            ResponseEntity.notFound();
        }
        Item item = new Item(comanda, dados);
        itemRepository.save(item);
        
        var uri = uriBuilder.path("/itens/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalheItemDto(item));
    }
}
