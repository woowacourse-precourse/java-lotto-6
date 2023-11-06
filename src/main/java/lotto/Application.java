package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.Lottos;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
