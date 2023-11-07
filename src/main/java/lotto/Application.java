package lotto;

import lotto.control.LottoController;
import lotto.view.OutputManager;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.simulate();
    }
}
