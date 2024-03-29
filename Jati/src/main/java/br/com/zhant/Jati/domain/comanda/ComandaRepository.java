package br.com.zhant.Jati.domain.comanda;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    public List<Comanda> findAllByAbertaTrue();
}
