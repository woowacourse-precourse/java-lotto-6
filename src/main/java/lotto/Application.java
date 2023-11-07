package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {

        LottoGameController controller = new LottoGameController(new InputView(), new LottoGameService());
        controller.run();
    }
}
