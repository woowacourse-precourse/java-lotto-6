package lotto;

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
            System.out.println("예기치 않은 오류로 인해 어플리케이션을 종료합니다.");
            throw e;
        }
    }

    private static LottoGame getLottoGame() {
        return new LottoGame(
                new LottoGameView(
                        new ConsoleInput(), new ConsoleOutput()
                ),
                new LottosRandoms(),
                new ConsoleOutput()
        );
    }

}
