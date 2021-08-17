package br.com.estudos.games.repository;

import br.com.estudos.games.model.Game;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameRepository {

    @Select("SELECT * FROM GAMES")
    List<Game> findAll();

    @Select("SELECT * FROM GAMES WHERE id=#{id}")
    Optional<Game> findById(Long id);

    @Update("UPDATE GAMES SET nome=#{nome}, anoDeLancamento=#{anoDeLancamento} WHERE id=#{id}")
    int update(Game game);

    @Insert("INSERT INTO GAMES (nome, anoDeLancamento) VALUES (#{nome},#{anoDeLancamento})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void save(Game game);

    @Delete("DELETE FROM GAMES WHERE id =#{id}")
    void delete(Game findByIdOrThrowException);

}
