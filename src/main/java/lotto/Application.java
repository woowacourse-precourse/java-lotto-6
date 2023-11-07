package lotto;

import lotto.io.UserInput;
import lotto.io.UserOutput;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(
                new UserInput(),
                new UserOutput()
        );

        lottoGame.play();
    }
}
