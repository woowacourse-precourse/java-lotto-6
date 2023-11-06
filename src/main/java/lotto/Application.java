package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        lottoController.run();
    }
}
