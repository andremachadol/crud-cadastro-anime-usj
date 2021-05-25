package br.edu.usj.ads.pw.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class AnimeController {
    
    @Autowired
    AnimeRepository animeRepository;
    
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
        
        return null;
    }
    
}
