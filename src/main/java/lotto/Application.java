package lotto;

import lotto.controller.LottoController;
import lotto.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = ComponentFactory.getInstance();
        final LottoController lottoController = componentFactory.lottoController();
        lottoController.run();
    }
}
