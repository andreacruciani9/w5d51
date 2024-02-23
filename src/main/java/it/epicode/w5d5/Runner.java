package it.epicode.w5d5;

import it.epicode.w5d5.entities.Edificio;
import it.epicode.w5d5.entities.Postazione;
import it.epicode.w5d5.entities.Prenotazione;
import it.epicode.w5d5.entities.Utente;


import it.epicode.w5d5.enums.TipoPostazione;
import it.epicode.w5d5.repositories.EdificioRepository;
import it.epicode.w5d5.repositories.PostazioneRepository;
import it.epicode.w5d5.repositories.PrenotazioneRepository;
import it.epicode.w5d5.repositories.UtenteRepository;
import it.epicode.w5d5.services.PostazioneService;
import it.epicode.w5d5.services.PrenotazioneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Inizio runner");

        Edificio edificio1 = new Edificio();
        edificio1.setNome("oriuti");
        edificio1.setIndirizzo("europa 27");
        edificio1.setCitta("Roma");

        Postazione postazione1 = new Postazione();
        postazione1.setCodice("123");
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipo(TipoPostazione.PRIVATO);
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio1);

        Utente utente = new Utente();
        utente.setUsername("ciccio");
        utente.setNomeCompleto("ciccio pasticcio");
        utente.setEmail("ciccio.pasticcio@gmail.com");

        Utente utente2 = new Utente();
        utente2.setUsername("andy94");
        utente2.setNomeCompleto("Andrea cruc");
        utente2.setEmail("andy94@gmail.com");

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente2);
        prenotazione.setPostazione(postazione1);
        prenotazione.setDataPrenotazione(LocalDate.of(2020, 8, 12));

        edificioRepository.save(edificio1);
        postazioneRepository.save(postazione1);
        utenteRepository.save(utente);
        utenteRepository.save(utente2);
        prenotazioneRepository.save(prenotazione);
        prenotazioneService.cercaPostazioni(TipoPostazione.OPENSPACE, "Città di Esempio");
        prenotazioneService.effettuaPrenotazione("andy94", 1L, LocalDate.now());
        prenotazioneService.effettuaPrenotazione("ciccio", 1L, LocalDate.now());

        List<Postazione> postazioni = postazioneService.cercaPostazioni(TipoPostazione.OPENSPACE, "Città di Esempio");

        logger.info("Fine runner.");

    }
}
