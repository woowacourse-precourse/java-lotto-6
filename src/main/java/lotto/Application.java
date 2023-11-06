package lotto;

import java.util.List;
import lotto.game.LottoGame;
import lotto.game.io.views.LottoGameView;
import lotto.io.ConsoleInput;

public class Application {

    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame(new LottoGameView(new ConsoleInput()), () -> List.of(1, 2, 3, 4, 5, 6));
            lottoGame.run();
        } catch (Exception e) {
            System.out.println("예기치 않은 오류로 인해 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}
