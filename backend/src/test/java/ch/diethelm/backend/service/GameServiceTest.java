package ch.diethelm.backend.service;

import ch.diethelm.backend.model.Game;
import ch.diethelm.backend.repository.GameRepository;
import ch.diethelm.backend.service.GameService;
import org.glassfish.jaxb.core.v2.model.core.ID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game sampleGame;

    @BeforeEach
    void setUp() {
        sampleGame = new Game();
        sampleGame.setTitle("Minh Game");
        sampleGame.setDescription("Minh is super cool");
        sampleGame.setImageUrl("http://minh.com/image.png");
    }

    @Test
    void getAllGames_ReturnsListFromRepository() {
        List<Game> expectedGames = Arrays.asList(sampleGame, new Game());
        when(gameRepository.findAll()).thenReturn(expectedGames);

        List<Game> actualGames = gameService.getAllGames();

        assertEquals(2, actualGames.size());
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    void getGameById_ExistingId_ReturnsGame() {

        Long id = new Long(1);

        when(gameRepository.findById(id)).thenReturn(Optional.of(sampleGame));

        Game result = gameService.getGameById(id);

        Assertions.assertNotNull(result);
        assertEquals("Minh Game", result.getTitle());
        verify(gameRepository, times(1)).findById(1L);
    }

    @Test
    void getGameById_NonExistingId_ThrowsException() {

        Long id = new Long(99);

        when(gameRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> gameService.getGameById(99L));
        verify(gameRepository, times(1)).findById(id);
    }

    @Test
    void createGame_CallsSaveAndReturnsSavedGame() {
        when(gameRepository.save(any(Game.class))).thenReturn(sampleGame);

        Game result = gameService.createGame(sampleGame);

        Assertions.assertNotNull(result);
        assertEquals("Minh Game", result.getTitle());
        verify(gameRepository, times(1)).save(sampleGame);
    }

    @Test
    void deleteGame_ExistingId_DeletesGame() {
        when(gameRepository.existsById(1L)).thenReturn(true);

        gameService.deleteGame(1L);

        verify(gameRepository, times(1)).existsById(1L);
        verify(gameRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteGame_NonExistingId_ThrowsException() {
        when(gameRepository.existsById(99L)).thenReturn(false);

        assertThrows(NoSuchElementException.class, () -> gameService.deleteGame(99L));

        verify(gameRepository, times(1)).existsById(99L);
        verify(gameRepository, never()).deleteById(anyLong());
    }
}
