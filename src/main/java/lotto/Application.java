package lotto;

import lotto.controller.LottoController;
import lotto.domain.Calculator;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new NumberGenerator(), new Calculator());
        controller.start();
    }
}
