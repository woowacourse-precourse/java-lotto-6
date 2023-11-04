package lotto;

import lotto.controller.PurchaseController;
import lotto.domain.lottery.Lottos;

public class Application {
    public static void main(String[] args) {
        PurchaseController lottoMachine = new PurchaseController();

        Lottos lottos = lottoMachine.purchase();
    }
}
