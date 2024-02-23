package it.epicode.w5d5.repositories;

import it.epicode.w5d5.entities.Postazione;
import it.epicode.w5d5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}
