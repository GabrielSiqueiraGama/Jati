package br.com.zhant.Jati.domain.comanda;

import br.com.zhant.Jati.domain.usuario.Usuario;
import jakarta.persistence.*;

@Entity(name = "tb_comandas")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    private boolean aberta;
}
