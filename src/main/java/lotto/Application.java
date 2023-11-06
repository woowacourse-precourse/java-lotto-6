package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController(new LottoNumberGenerator());
            lottoController.run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
