package lotto;

import lotto.controller.LottoController;
import lotto.instance.InstanceContainer;

public class Application {
    public static void main(String[] args) {
        InstanceContainer container = new InstanceContainer();
        LottoController lottoController = container.getLottoController();
        try {
            lottoController.run();
        } catch (UnsupportedOperationException exception) {
            System.out.println("[ERROR]" + exception.getMessage());
        }
    }
}
