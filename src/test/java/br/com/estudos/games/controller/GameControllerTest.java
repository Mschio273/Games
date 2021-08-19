package br.com.estudos.games.controller;

import br.com.estudos.games.model.Game;
import br.com.estudos.games.repository.GameRepository;
import br.com.estudos.games.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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