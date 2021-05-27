package br.edu.usj.ads.pw.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class AnimeController {
    
    @Autowired
    AnimeRepository animeRepository;


    @GetMapping(value="/")
    public ModelAndView getIndex() {
        List<Anime> lista = new ArrayList<>();
       
        lista = animeRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("lista", lista);
        
        return modelAndView;
    }

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        Anime anime= new Anime ();
        
        anime=animeRepository.findById(id).get();
       
        ModelAndView modelAndView = new ModelAndView("detalhes");

        modelAndView.addObject("anime", anime);

        return modelAndView;
    }
    

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        
        ModelAndView modelAndView = new ModelAndView("cadastro");
        return modelAndView;
    }
    
    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(@RequestParam String nome, @RequestParam  String genero, @RequestParam String eps){
        Anime anime = new Anime();
        anime.setNome(nome);
        anime.setGenero(genero);
        anime.setEps(eps);
        
        animeRepository.save(anime);
        ModelAndView modelAndView = new ModelAndView("detalhes");

        modelAndView.addObject("anime", anime);

        return modelAndView;
    }
    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        
        animeRepository.deleteById(id);

        return "redirect:/";
       
        
    }
    
}
