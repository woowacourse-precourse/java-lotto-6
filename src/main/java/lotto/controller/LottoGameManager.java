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

        
    }
}
