package lotto;

import lotto.controllers.InputProcessor;
import lotto.controllers.LottoStore;

import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore view = new LottoStore();
        view.purchaseController();
    }
}
