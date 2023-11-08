package lotto;

import lotto.controller.LottoRunner;

public class Application {

    public static void main(String[] args) {
        LottoRunner lottoRunner = LottoRunner.getLottoRunner();
        lottoRunner.runLottoApp();
    }
}
