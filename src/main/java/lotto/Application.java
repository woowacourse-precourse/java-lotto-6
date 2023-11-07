package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.utils.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.play();
    }
}
