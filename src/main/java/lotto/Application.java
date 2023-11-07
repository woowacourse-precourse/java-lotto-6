package lotto;

import static lotto.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.game.LottoGame;
import lotto.game.io.views.LottoGameView;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;
import lotto.io.lottos.LottosRandoms;

public class Application {

    public static void main(String[] args) {
        try {
            LottoGame lottoGame = getLottoGame();
            lottoGame.run();
        } catch (Exception e) {
            System.out.println(EXCEPTION_APPLICATION.get());
            throw e;
        }
    }

    private static LottoGame getLottoGame() {
        return new LottoGame(
                new LottoGameView(
                        new ConsoleInput(), new ConsoleOutput()
                ),
                new LottosRandoms()
        );
    }

}
