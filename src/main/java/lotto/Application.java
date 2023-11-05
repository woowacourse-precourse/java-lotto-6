package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        try {
            LottoController lottoController = new LottoController(lottoNumberGenerator);
            lottoController.run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
