package br.com.controle.de.gastos.controle.de.gastos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;
import jakarta.persistence.Id;

@Repository
public interface EntradaRepository extends JpaRepository<Entradas, Id> {

}
