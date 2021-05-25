package br.edu.usj.ads.pw.cadastro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnimeRepository extends CrudRepository<Anime, Long> {
    List<Anime> findAll();
}
