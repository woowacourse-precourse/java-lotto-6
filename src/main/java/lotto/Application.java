package lotto;

import lotto.controller.LottoController;
import lotto.domain.ProfitCalculator;
import lotto.controller.WinnerLottoFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(new ProfitCalculator(),new WinnerLottoFactory());
        controller.run();
    }
}
