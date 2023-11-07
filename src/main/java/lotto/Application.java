package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.util.random.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoService(new RandomNumberGenerator())
        );
        lottoController.run();
    }
}
