package lotto;

import static lotto.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.collaboration.lottos.Lottos;
import lotto.game.LottoGame;
import lotto.game.io.views.LottoGameView;
import lotto.game.io.views.LottosView;
import lotto.game.io.views.WinningLottoView;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;
import lotto.io.lottos.LottosRandoms;

public class Application {

    public static void main(String[] args) {
        runExceptionHandled(() -> {
            LottoGame lottoGame = getLottoGame();
            lottoGame.run();
        });
    }

    private static void runExceptionHandled(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println(EXCEPTION_APPLICATION.get());
            throw e;
        }
    }

    private static LottoGame getLottoGame() {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();
        return new LottoGame(
                new LottoGameView(
                        new LottosView(input, output),
                        new WinningLottoView(input, output)
                ),
                new LottosRandoms(),
                new Lottos()
        );
    }

}
