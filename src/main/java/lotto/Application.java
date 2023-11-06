package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoModel;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new LottoModel(), new LottoView());
        controller.run();
    }
}
