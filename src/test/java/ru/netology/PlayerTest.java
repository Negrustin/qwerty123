package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Кольца", "Аркады");

        Player player = new Player("Вася");
        player.installGame(game);

        int expected = 2;
        int actual = player.play(game, 2);

        assertEquals(expected, actual);
    }

    @Test

    public void shouldIfInstallTwoGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Кольца", "Аркады");
        Game game2 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Вася");
        player.installGame(game1);
        player.installGame(game2);

        int expected = 3;
        int actual = player.play(game2, 3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoubleInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Кольца", "Аркады");

        Player player = new Player("Вася");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);

        int expected = 3;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test

    public void shouldRuntimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Кольца", "Аркады");

        Player player = new Player("Вася");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 5);
        });

    }

    @Test
    public void shouldSumGenreIfSeveralGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game3, 1);

        int expected = 7;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfHoursZero() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 0);
        player.play(game2, 0);
        player.play(game3, 0);

        int expected = 0;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game3, 1);

        String expected = "Кольца";
        String actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreIfHoursZero() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 0);
        player.play(game2, 0);
        player.play(game3, 0);

        Assertions.assertNull(player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldIfNoGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game3, 1);

        Assertions.assertNull(player.mostPlayerByGenre("Шутер"));

    }

    // другие ваши тесты
}
