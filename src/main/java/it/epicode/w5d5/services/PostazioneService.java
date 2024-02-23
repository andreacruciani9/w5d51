package it.epicode.w5d5.services;

import it.epicode.w5d5.entities.Postazione;
import it.epicode.w5d5.enums.TipoPostazione;
import it.epicode.w5d5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
