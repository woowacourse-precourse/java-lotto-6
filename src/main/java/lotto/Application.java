package lotto;

import lotto.domain.LottoController;

public class Application {
    private static LottoController lottoController;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoController = new LottoController();
        lottoController.playGame();
    }
}
