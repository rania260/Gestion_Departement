package com.tekup.gestiondepartement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.gestiondepartement.model.CadreAdministratif;
import com.tekup.gestiondepartement.service.CadreAdminService;

@RestController
public class CadreAdminController {
    @Autowired
    private CadreAdminService service;
    
    @GetMapping("/interfaceAdmin")
    public String home(Model model) {
        // Process data or logic
        return "interfaceAdmin"; // Return the name of the HTML template without the file extension
    }

      // Add API
      @PostMapping("/addCadreAdministratif")
      public CadreAdministratif addCadreAdmin(@RequestBody CadreAdministratif Cadre){
          return service.saveCadreAdministratif(Cadre);
      }
   
      @PostMapping("/addCadreAdministratifs")
      public List<CadreAdministratif> addCadreAdmins(@RequestBody List<CadreAdministratif> Cadres){
          return service.saveCadreAdmin(Cadres);
      }
    //GetAPI
    @GetMapping("/CadreAdministratifs")
    public List<CadreAdministratif> findAllCadres(){
        return service.getCadreAdmin();
    }
 
    @GetMapping("/CadreAdministratif/{id}")
    public CadreAdministratif findCadreById(@PathVariable int id){
        return service.getCadreAdminById(id);
    }

    @GetMapping("/CadreAdministratif/{name}")
    public CadreAdministratif findCadreByName(@PathVariable String name){
        return service.getCadreAdminByName(name);
    }
//update 

    @PutMapping("/updateCadre")
    public CadreAdministratif updateCadre(@RequestBody CadreAdministratif cadre){
        return service.updateCadreAdmin(cadre);
    }

    @DeleteMapping("/deleteCadre/{id}")
    public String deleteCadre(@PathVariable int id){
        return service.deleteCadreAdmin(id);
    }
}