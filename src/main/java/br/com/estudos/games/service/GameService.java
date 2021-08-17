package br.com.estudos.games.service;

import br.com.estudos.games.exception.BadRequestException;
import br.com.estudos.games.model.Game;
import br.com.estudos.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return this.gameRepository.findAll();
    }

    public Game findByIdOrThrowException(Long id){
        return this.gameRepository.findById(id).orElseThrow(() -> new BadRequestException("Id não encontrado"));
    }

    public void update(Game game){
        this.gameRepository.update(game);
    }

    public Game save(Game game){
        gameRepository.save(game);
        return game;
    }

    public void delete(Long id){
        this.gameRepository.delete(findByIdOrThrowException(id));
    }
}
