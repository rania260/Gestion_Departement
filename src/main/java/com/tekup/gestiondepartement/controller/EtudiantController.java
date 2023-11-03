package com.tekup.gestiondepartement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.service.EtudiantService;


//@RestController
@Controller
public class EtudiantController {
    @Autowired
    private EtudiantService service;
    
    @GetMapping("/interfaceetudiant")
    public String home(Model model) {
        List<Etudiants> etudiant = service.getEtudiant();
        model.addAttribute("etudiant",etudiant );
        return "interfaceetudiant"; 
    }
// Add API
    @PostMapping("/addEtudiant")
    public Etudiants addEtudiant(@RequestBody Etudiants etudiant){
        return service.saveEtudiant(etudiant);
    }
 
    @PostMapping("/addEtudiants")
    public List<Etudiants> addEtudiants(@RequestBody List<Etudiants> etudiants){
        return service.saveEtudiants(etudiants);
    }
//GetAPI
    @GetMapping("/Etudiants")
    public List<Etudiants> findAllEtudiants(){
        return service.getEtudiant();
    }
 
    @GetMapping("/Etudiant/{id}")
    public Etudiants findEtudiantById(@PathVariable int id){
        return service.getEtudiantById(id);
    }

    @GetMapping("/Etudiant/{name}")
    public Etudiants findEtudiantByName(@PathVariable String name){
        return service.getEtudiantByName(name);
    }
//update 

    @PutMapping("/updateEtudiant")
    public Etudiants updateEtudiant(@RequestBody Etudiants etudiant){
        return service.updateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public String deleteEtudiant(@PathVariable int id){
        return service.deleteEtudiant(id);
    }

}