package lotto.controller;

import lotto.model.Purchase;

public class LottoGameManager {

    private final UserInputManager userInputManager;

    public LottoGameManager(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    public void play() {
        String purchasePriceInput = userInputManager.getPurchasePriceInput();
        Purchase purchase = new Purchase(purchasePriceInput);
        int lottoCount = purchase.getLottoCount();

        System.out.println(lottoCount);

        // 추가적인 로직을 수행할 수 있습니다.
    }
}
