package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController controller = new LottoGameController();
        controller.play();
    }
}
