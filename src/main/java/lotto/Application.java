package lotto;

import lotto.controller.LottoController;
import lotto.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        final LottoController lottoController = ComponentFactory.INSTANCE.lottoController();
        lottoController.run();
    }
}
