package lotto.console;

import lotto.console.game.lotto.LottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameConsoleTest {

    GameConsole console;

    @BeforeEach
    void setup() {
        console = new GameConsole();
    }

    @Test
    void console_start_mocking_test() {
        // given
        LottoGame lottoGame = Mockito.mock(LottoGame.class);
        console.addGame(lottoGame);

        // when
        console.start();

        // then
        Mockito.verify(lottoGame).start();
    }

    @Test
    void console_start_without_mocking_test() {
        // given
        LottoGame lottoGame = new LottoGame();
        console.addGame(lottoGame);

        // when
        console.start();
    }
}