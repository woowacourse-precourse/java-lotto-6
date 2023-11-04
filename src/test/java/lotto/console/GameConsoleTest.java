package lotto.console;

import lotto.console.game.lotto.LottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.BDDAssertions.then;

class GameConsoleTest {

    GameConsole console;

    @BeforeEach
    void setup() {
        console = new GameConsole();
    }

    @Test
    void console_start_mocking_test() {
        LottoGame lottoGame = Mockito.mock(LottoGame.class);
        console.addGame(lottoGame);
        console.start();
        Mockito.verify(lottoGame).start();
    }

    @Test
    void console_start_without_mocking_test() {
        LottoGame lottoGame = new LottoGame();
        console.addGame(lottoGame);
        console.start();
    }
}