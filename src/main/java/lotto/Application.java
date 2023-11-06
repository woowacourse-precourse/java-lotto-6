package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
        try {
            LottoController lottoController = new LottoController(lottoGenerator);
            lottoController.run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
