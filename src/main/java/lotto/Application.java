package lotto;

import lotto.view.LottoView;
import lotto.controller.LottoController;
public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();

        LottoController controller = new LottoController(view);

        controller.run();
    }
}

