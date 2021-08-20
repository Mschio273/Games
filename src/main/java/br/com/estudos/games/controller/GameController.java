package br.com.estudos.games.controller;

import br.com.estudos.games.model.Game;
import br.com.estudos.games.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
@Api(value = "API REST de Games")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um game")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game findById(@PathVariable Long id){
        return gameService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualiza um game")
    public void update(@RequestBody Game game){
        gameService.update(game);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um game")
    public Game save(@RequestBody Game game){
        return gameService.save(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta um game")
    public void delete(@PathVariable Long id){
        this.gameService.delete(id);
    }
}
