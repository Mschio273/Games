package br.com.estudos.games.service;

import br.com.estudos.games.model.Game;
import br.com.estudos.games.repository.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameService gameService;

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
        var response = gameService.findAll();
        assertEquals(listaGames, response);

    }
}