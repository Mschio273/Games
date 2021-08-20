package br.com.estudos.games.service;

import br.com.estudos.games.model.Game;
import br.com.estudos.games.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        List<Game> listaGames = List.of(gamesEsperados);

        when(gameRepository.findAll()).thenReturn(List.of(game));

        List<Game> response = gameService.findAll();

        assertEquals(listaGames, response);
    }
}