package lotto.controller;

import static lotto.view.InputView.requestPurchaseAmount;

import lotto.domain.PurchaseAmount;

public class LottoController {

    public static void start(){
        int inputPurchaseAmount = requestPurchaseAmount();
        PurchaseAmount.creat(inputPurchaseAmount);

    }
}