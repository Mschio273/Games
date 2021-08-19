package br.com.estudos.games.controller;

import br.com.estudos.games.model.Game;
import br.com.estudos.games.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @InjectMocks
    GameController gameController;

    @Mock
    GameRepository gameRepository;

    @Test
    void test(){
        Game game = Game.builder()
                .nome("sonic")
                .build();
        Game gamesEsperados = Game.builder()
                .nome("sonic")
                .build();
        var listaGames = List.of(gamesEsperados);

        when(gameRepository.findAll()).thenReturn(List.of(game));

        var response = gameController.findAll();
        assertEquals(listaGames, response);

    }
}