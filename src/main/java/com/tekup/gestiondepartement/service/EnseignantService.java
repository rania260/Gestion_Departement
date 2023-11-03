package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.repository.EnseignantRepository;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository repository;

    //post methode
    public Enseignant saveEnseignant (Enseignant enseignant){

       return repository.save(enseignant);
    }

     public List<Enseignant> saveEnseignant (List<Enseignant> enseignants){

       return repository.saveAll(enseignants);
    }

    //get methode
    public List<Enseignant> getEnseignant(){
      return repository.findAll();
  }

  public Enseignant getEnseignantById(int id){
      return repository.findById(id).orElse(null);
  }

  public Enseignant getEnseignantByName(String name){
      return repository.findByName(name);
  }

//delete methode
  public String deleteEnseignant(int id){
      repository.deleteById(id);
      return "Enseignant supprimer!! " +id;
  }
//update methode
  public Enseignant updateEnseignant(Enseignant enseignant){
      Enseignant existingEnseignant = repository.findById(enseignant.getId()).orElse(null);
      existingEnseignant.setName(enseignant.getName());
      existingEnseignant.setPrenom(enseignant.getPrenom());
      existingEnseignant.setSpecialite(enseignant.getSpecialite());
      existingEnseignant.setMatricule(enseignant.getMatricule());
      return repository.save(existingEnseignant);

      
  }

    
}