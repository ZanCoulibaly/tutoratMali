package com.example.apitutorat.demande.service;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.demande.Etat;
import com.example.apitutorat.demande.repository.DemandeRepository;
import com.example.apitutorat.notification.Notification;
import com.example.apitutorat.notification.repository.NotificationRepository;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DemandeServiceImp implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public Demande sendDemande(Long from, Long to, String matiere) {
        Utilisateur sender= usersRepository.findById(from).get();
        Utilisateur receveur= usersRepository.findById(to).get();

        Demande demande= new Demande();
        demande.setEnvoyeur(sender);
        demande.setReceveur(receveur);
        demande.setMatiere(matiere);
        demande.setDate(LocalDate.now());
        demande.setContenu("Vous solicite en "+matiere);

        //receveur.setOldTotale(receveur.getTotaleNotif());
        receveur.setTotaleNotif(receveur.getTotaleNotif()+1);

         usersRepository.save(receveur);
        return demandeRepository.save(demande);
    }

    @Override
    public void InitierDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        if (demande.isInitier()){
            demande.setInitier(false);
        }else {
            demande.setInitier(true);
        //***********---*-*-****-*-*-**-*-*-*-*-*add notification
//*-*-*-*-*-*-*-*-*-*-*-l'ensemble de ses methodes permettent d'envoyer une notifier lorsqu'on inicitie une demande*******
            Notification notification = new Notification();
            notification.setHeure(LocalTime.now());
            notification.setDate(LocalDate.now());
            notification.setContenu(demande.getReceveur().getPrenom()+" "+demande.getReceveur().getNom()+" a initié votre demade");
            notification.setEnvoyeur(demande.getReceveur());
            notification.setReceveur(demande.getEnvoyeur());
            notificationRepository.save(notification);
        }
        demandeRepository.save(demande);
    }

    @Override
    public Demande declinerDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        demande.setEtat(Etat.DECLINER);

       return demandeRepository.save(demande);
    }

    @Override
    public Demande accepterDemande(Long id) {
        Demande demande= demandeRepository.findById(id).get();
        demande.setEtat(Etat.ACCEPTER);
        demande.setAcceptDate(LocalDate.now());
        demande.setAcceptHeure(LocalTime.now());

        //***********---*-*-****-*-*-**-*-*-*-*-*add notification
//*-*-*-*-*-*-*-*-*-*-*-l'ensemble de ses methodes permettent d'envoyer une notifier lorsqu'on accepte une demande*******
        Notification notification = new Notification();
        notification.setHeure(LocalTime.now());
        notification.setDate(LocalDate.now());
        notification.setContenu(demande.getReceveur().getPrenom()+" "+demande.getReceveur().getNom()+" a accepter votre demade");
        notification.setEnvoyeur(demande.getReceveur());
        notification.setReceveur(demande.getEnvoyeur());
        notificationRepository.save(notification);

        return demandeRepository.save(demande);
    }

    //---------------liste des deamndes-------------------------------
    @Override
    public List<Demande> listesAllDemande(Long from_id, Long to_id) {
        Utilisateur from= usersRepository.findById(from_id).get();
        Utilisateur to= usersRepository.findById(to_id).get();
        return demandeRepository.findByEnvoyeurAndReceveurAndEtatIsTrue(from,to);
    }

    @Override
    public List<Demande> ListDemandeRejeter(Long id) {
        Utilisateur receveur = usersRepository.findById(id).get();
        return demandeRepository.findByReceveurAndEtat(receveur, Etat.DECLINER );
    }

    @Override
    public List<Demande> ListDemandeAccepter(Long id) {
        Utilisateur receveur = usersRepository.findById(id).get();
        return demandeRepository.findByReceveurAndEtat(receveur, Etat.ACCEPTER);
    }

    //------------fin

    //----------supprimer demandes-------
    @Override
    public Demande SupprimerDemande(Long id) {
        return null;
    }

    //-----------------fin

    @Override
    public List<Demande> GetByReceveur(Long id) {
        Utilisateur user= usersRepository.findById(id).get();
        return demandeRepository.findByReceveur(user);
    }

    @Override
    public List<Demande> ListeAllInitier() {
        return demandeRepository.findByInitierIsTrue();
    }

    @Override
    public List<Demande> InitierByEnvoyeurAndReceveur(Long from_id) {
        Utilisateur envoyeur= usersRepository.findById(from_id).get();

        return demandeRepository.findByReceveurAndInitierIsTrue(envoyeur);
    }

    @Override
    public List<Demande> InitierByReceveurAndEnvoyeur(Long to_id) {
        Utilisateur receveur = usersRepository.findById(to_id).get();
        return  demandeRepository.findByEnvoyeurAndInitierIsTrue(receveur);
    }

    @Override
    public Demande DEMANDEById(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        return demande;
    }

    @Override
    public Demande demandeByMatiere(Long from, Long to, String matiere) {
        Utilisateur sender= usersRepository.findById(from).get();
        Utilisateur receveur= usersRepository.findById(to).get();
        return demandeRepository.findByEnvoyeurAndReceveurAndMatiere(sender, receveur, matiere);
    }

    //----------la liste des demandes accepter d'un users differents de tuteur


    @Override
    public List<Demande> ListDemandeAccepterByEnvoyeur(Long id) {
        Utilisateur user= usersRepository.findById(id).get();
        return demandeRepository.findByEnvoyeurAndEtat(user, Etat.ACCEPTER);
    }

    //------------nombre totale de demande--------------

    @Override
    public int nombreTotaleDemade() {
        List<Demande> list = demandeRepository.findAll();
        int a = list.size();
        return a;
    }

    @Override
    public int nombreTotaleAccepter() {
        List<Demande> list = demandeRepository.findByEtat(Etat.ACCEPTER);
        int a = list.size();
        return a;
    }

    @Override
    public int nombreTotaleDecliner() {
        List<Demande> list = demandeRepository.findByEtat(Etat.DECLINER);
        int a = list.size();
        return a;
    }
}
