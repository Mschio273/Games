package br.com.estudos.games.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Long id;
    private String nome;
    private LocalDate anoDeLancamento;
}
