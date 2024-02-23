package it.epicode.w5d5.repositories;

import it.epicode.w5d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
