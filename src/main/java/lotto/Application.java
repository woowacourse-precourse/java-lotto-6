package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.LottoMachine;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
