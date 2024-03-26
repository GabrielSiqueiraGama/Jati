package br.com.zhant.Jati.domain.comanda;

import br.com.zhant.Jati.domain.comanda.item.Item;
import br.com.zhant.Jati.domain.dto.editarComandaDto;
import br.com.zhant.Jati.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "tb_comandas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itens;

    private boolean aberta;

    public Comanda(Usuario usuario) {
        this.usuario = usuario;
        this.aberta = true;
    }

    public void update(editarComandaDto dados) {
        if(dados.aberta() != null){
            this.aberta = dados.aberta();
        }
        if(dados.usuario() != null){
            this.usuario = dados.usuario();
        }
    }
}
