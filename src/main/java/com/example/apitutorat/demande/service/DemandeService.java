package com.example.apitutorat.demande.service;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.users.Etat;
import com.example.apitutorat.users.Utilisateur;

import java.util.List;

public interface DemandeService {
    public Demande sendDemande(Long from, Long to, String matiere);
    public void InitierDemande(Long id);
    public Demande declinerDemande(Long id);
    public Demande accepterDemande(Long id);

    public List<Demande> listesAllDemande(Long from_id, Long to_id);
    public List<Demande> GetByReceveur(Long id);
    public List<Demande> ListeAllInitier();
    public List<Demande> InitierByEnvoyeurAndReceveur(Long from_id);
    public List<Demande> InitierByReceveurAndEnvoyeur(Long to_id);
    public Demande DEMANDEById(Long id);
    public Demande demandeByMatiere(Long from, Long to, String matiere);

    //liste des demabde accepter ou decliner d'une personne donnée
    public List<Demande> ListDemandeRejeter(Long id);
    public List<Demande> ListDemandeAccepter(Long id);
    public Demande SupprimerDemande(Long id);

    //la liste des demandes accepter des uilisateurs autre que le tuteur
    public List<Demande> ListDemandeAccepterByEnvoyeur(Long id);


    //----nombre totale de demande accepter et decliner

    public int nombreTotaleDemade();
    public int nombreTotaleAccepter();
    public int nombreTotaleDecliner();


}
