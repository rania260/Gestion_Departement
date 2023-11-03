package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.repository.EtudiantRepository;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository repository; 
//post methode
    public Etudiants saveEtudiant (Etudiants etudiants){

       return repository.save(etudiants);
    }

     public List<Etudiants> saveEtudiants (List<Etudiants> etudiantss){

       return repository.saveAll(etudiantss);
    }
//get methode
    public List<Etudiants> getEtudiant(){
        return repository.findAll();
    }

    public Etudiants getEtudiantById(int id){
        return repository.findById(id).orElse(null);
    }

    public Etudiants getEtudiantByName(String name){
        return repository.findByName(name);
    }

//delete methode
    public String deleteEtudiant(int id){
        repository.deleteById(id);
        return "Etidiant supprimer!! " +id;
    }
//update methode
    public Etudiants updateEtudiant(Etudiants etudiant){
        Etudiants existingEtudiant = repository.findById(etudiant.getId()).orElse(null);
        existingEtudiant.setName(etudiant.getName());
        existingEtudiant.setPrenom(etudiant.getPrenom());
        existingEtudiant.setAge(etudiant.getAge());
        existingEtudiant.setMatricule(etudiant.getMatricule());
        existingEtudiant.setNiveau(etudiant.getNiveau());
        return repository.save(existingEtudiant);

        
    }

}