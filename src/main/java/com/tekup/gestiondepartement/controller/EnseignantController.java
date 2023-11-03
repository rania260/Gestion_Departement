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

import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.service.EnseignantService;

@RestController
public class EnseignantController {
    @Autowired
    private EnseignantService service;

    @GetMapping("/interfaceEnseignant")
    public String home(Model model) {
        // Process data or logic
        return "interfaceEnseignant"; // Return the name of the HTML template without the file extension
    }

    // Add API
    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant){
        return service.saveEnseignant(enseignant);
    }
 
    @PostMapping("/addEnseignants")
    public List<Enseignant> addEnseignants(@RequestBody List<Enseignant> enseignants){
        return service.saveEnseignant(enseignants);
    }

    //GetAPI
    @GetMapping("/Enseignants")
    public List<Enseignant> findAllEnseignants(){
        return service.getEnseignant();
    }
 
    @GetMapping("/Enseignant/{id}")
    public Enseignant findEtudiantById(@PathVariable int id){
        return service.getEnseignantById(id);
    }

    @GetMapping("/Enseignant/{name}")
    public Enseignant findEnseignantByName(@PathVariable String name){
        return service.getEnseignantByName(name);
    }
//update 

    @PutMapping("/updateEnseignant")
    public Enseignant updateEnseignant(@RequestBody Enseignant enseignant){
        return service.updateEnseignant(enseignant);
    }

    @DeleteMapping("/deleteEnseignant/{id}")
    public String deleteEnseignant(@PathVariable int id){
        return service.deleteEnseignant(id);
    }
}