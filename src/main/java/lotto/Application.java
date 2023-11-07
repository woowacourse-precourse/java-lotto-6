package lotto;

import lotto.domain.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.activate();
    }
}
