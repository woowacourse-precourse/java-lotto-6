package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.Purchase;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(
                new LottoMachine(), new LottoStatistics(), new Purchase());
        lottoController.run();
    }
}
