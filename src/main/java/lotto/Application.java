package lotto;

import lotto.controller.LottoController;
import lotto.domain.ProfitCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(new ProfitCalculator());
        controller.run();
    }
}
