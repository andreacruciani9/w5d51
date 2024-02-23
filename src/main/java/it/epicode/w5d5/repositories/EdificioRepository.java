package it.epicode.w5d5.repositories;

import it.epicode.w5d5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
