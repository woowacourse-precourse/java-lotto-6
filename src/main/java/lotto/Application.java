package lotto;

import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame controller = new LottoGame();
        controller.play();
    }
}
