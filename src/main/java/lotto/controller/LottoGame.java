package lotto.controller;

import lotto.service.LottoSeller;
import lotto.userInterface.InputViewer;
import lotto.utils.StringChanger;

public class LottoGame {
    LottoSeller lottoSeller;

    public void init() {
        lottoSeller = new LottoSeller();
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        String userInput = InputViewer.requestAmountInput();
        userInput = StringChanger.trimString(userInput);
        lottoSeller.getAmount(userInput);
    }
}
