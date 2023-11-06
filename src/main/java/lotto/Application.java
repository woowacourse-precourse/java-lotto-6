package lotto;

import lotto.controllers.LottoStoreManager;

import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getPurchaseAmountPromptMessage();

        LottoStoreManager lottoController = new LottoStoreManager();
        lottoController.purchaseController();

        System.out.println();
    }
}
