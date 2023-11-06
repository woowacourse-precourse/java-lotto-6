package lotto;

import lotto.controller.LottoController;
import lotto.instance.InstanceContainer;

public class Application {
    public static void main(String[] args) {
        InstanceContainer container = new InstanceContainer();
        LottoController lottoController = container.getLottoController();
        lottoController.run();
    }
}
