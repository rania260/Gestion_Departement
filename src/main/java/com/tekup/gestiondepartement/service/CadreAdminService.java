package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.CadreAdministratif;
import com.tekup.gestiondepartement.repository.CadreAdminRepository;

@Service
public class CadreAdminService {
    @Autowired
    private CadreAdminRepository repository;

    //post methode
    public CadreAdministratif saveCadreAdministratif (CadreAdministratif cadreAdmin){

        return repository.save(cadreAdmin);
     }
 
      public List<CadreAdministratif> saveCadreAdmin (List<CadreAdministratif> cadreAdmins){
 
        return repository.saveAll(cadreAdmins);
     }
 
     //get methode
     public List<CadreAdministratif> getCadreAdmin(){
       return repository.findAll();
   }
 
   public CadreAdministratif getCadreAdminById(int id){
       return repository.findById(id).orElse(null);
   }
 
   public CadreAdministratif getCadreAdminByName(String name){
       return repository.findByName(name);
   }
 
 //delete methode
   public String deleteCadreAdmin(int id){
       repository.deleteById(id);
       return "Cadre Administrateur supprimer!! " +id;
   }
 //update methode
   public CadreAdministratif updateCadreAdmin(CadreAdministratif cadreAdmin){
       CadreAdministratif existingCadre = repository.findById(cadreAdmin.getId()).orElse(null);
       existingCadre.setName(cadreAdmin.getName());
       existingCadre.setPrenom(cadreAdmin.getPrenom());
       existingCadre.setFonction(cadreAdmin.getFonction());
       existingCadre.setMatricule(cadreAdmin.getMatricule());
       return repository.save(existingCadre);
 
       
   }

}