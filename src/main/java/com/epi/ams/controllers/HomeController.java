package com.epi.ams.controllers;

import com.epi.ams.entities.Candidat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    @RequestMapping("/index")
    // @ResponseBody
    public String home(){
        //return"<h2>Bienvenue au BootCamp</h2>";
        return "home/index";
    }

    @RequestMapping("/candidats")
    public String listCandidats(Model m){  // Model permet de transferer les donnees vers le view(.html) avec la methode add attribute

        Candidat c1 = new Candidat(1,"fedi","fediHammami@gmail.com","54422162");
        Candidat c2 = new Candidat(2,"tayeb","tayebHammami@gmail.com","27520175");
        Candidat c3 = new Candidat(3,"isra","israHammami@gmail.com","54422662");
        Candidat tab[] = new Candidat[3];
        tab[0]= c1;tab[1]= c2;tab[2]= c3;
        String libelleFormation = "Spring boot Angulair";
        String formateur = "Med Amin";
        m.addAttribute("lf",libelleFormation);
        m.addAttribute("trainer",formateur);
        m.addAttribute("tab",tab);
        return "home/candidats";
    }
    @GetMapping("/add")
    public String addCandidate(){
        return "home/add";
    }
}
