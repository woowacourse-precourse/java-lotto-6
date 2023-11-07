package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoBuySystem;
import lotto.model.LottoDrawSystem;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoBuySystem buySystem = new LottoBuySystem();
        LottoDrawSystem drawSystem = new LottoDrawSystem();
        LottoView view = new LottoView();
        LottoController controller = new LottoController(buySystem, drawSystem, view);

        controller.run();

    }
}
