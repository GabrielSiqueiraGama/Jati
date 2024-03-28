package br.com.zhant.Jati.domain.comanda.item;

import br.com.zhant.Jati.domain.comanda.Comanda;
import br.com.zhant.Jati.domain.comanda.item.dto.CriaItensDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "tb_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    @Column(scale = 2)
    private BigDecimal preco;

    public Item(Comanda comanda, CriaItensDto dados) {
        this.comanda = comanda;
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.nome = dados.nome();
    }
}
