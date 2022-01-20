package com.epi.ams.controllers;

import com.epi.ams.entities.Candidat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
class HomeController {

    static ArrayList<Candidat> lc; // il faut definir lc  comme static pour pouvoir le manipuler dans le tableau static

    static {   // tableau static
        lc = new ArrayList<>();
        Candidat c1 = new Candidat(1,"fedi","fediHammami@gmail.com","54422162");
        Candidat c2 = new Candidat(2,"tayeb","tayebHammami@gmail.com","27520175");
        Candidat c3 = new Candidat(3,"isra","israHammami@gmail.com","54422662");
        lc.add(c1); lc.add(c2); lc.add(c3);
    }

    @RequestMapping("/index")
    // @ResponseBody
    public String home(){
        //return"<h2>Bienvenue au BootCamp</h2>";
        return "home/index";
    }

    @RequestMapping("/candidats")
    public String listCandidats(Model m){  // Model permet de transferer les donnees vers le view(.html) avec la methode add attribute

        /* Candidat c1 = new Candidat(1,"fedi","fediHammami@gmail.com","54422162");
        Candidat c2 = new Candidat(2,"tayeb","tayebHammami@gmail.com","27520175");
        Candidat c3 = new Candidat(3,"isra","israHammami@gmail.com","54422662");
        Candidat tab[] = new Candidat[3];
        tab[0]= c1;tab[1]= c2;tab[2]= c3;*/
        String libelleFormation = "Spring boot Angulair";
        String formateur = "Med Amin";

        m.addAttribute("lf",libelleFormation);
        m.addAttribute("trainer",formateur);
        m.addAttribute("tab",lc);
        return "home/candidats";
    }

    @GetMapping("/add")
    public String addCandidate(){
        return "home/add";
    }

    @PostMapping("/add")
    // @ResponseBody : pour afficher dans le html
    public String saveCandidate(@RequestParam("id") int id,
                                @RequestParam("nom") String nom,
                                @RequestParam("email") String email,
                                @RequestParam("tel") String tel){
        Candidat temp = new Candidat(id,nom,email,tel);
        lc.add(temp);
        //return "infos : "+id+" "+nom+" "+email+" "+tel;
        return "redirect:candidats";
    }

    @GetMapping("/show/{idC}")
    @ResponseBody
    public String show(@PathVariable("idC") int id){
        return "ID : "+id;
        //return"home/show";
    }

    @GetMapping("/delete/{idC}")
    public String delete(@PathVariable("idC") int id){
        lc.remove(id);
        return "redirect:../candidats";
        //return"home/show";
    }
}
