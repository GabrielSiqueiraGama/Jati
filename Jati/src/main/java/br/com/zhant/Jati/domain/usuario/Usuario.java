package br.com.zhant.Jati.domain.usuario;


import br.com.zhant.Jati.domain.usuario.dto.CriaUsuarioDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "tb_usuario")
@Getter//Cria os getters
@NoArgsConstructor// Cria um construtor sem argumentos
@AllArgsConstructor//Cria um construtor com todos os argumentos
@EqualsAndHashCode(of = "id")//Procura apelas pelo id
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String email;

    private String telefone;

    public Usuario(CriaUsuarioDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}
