package it.epicode.w5d5.entities;

import it.epicode.w5d5.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_fk")
    private Edificio edificio;
}
