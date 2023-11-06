package lotto.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final int lottoPrice = 1000;
    private int purchaseQuantity;


    public void start() {

        initPurchaseQuantity(); // 구매 수량 초기화
        outputPurchaseQuantity();
    }

    public void initPurchaseQuantity() {
        String input = InputView.inputAmountOfMoney();
        calculateQuantity(input);
    }

    private void calculateQuantity(String input) { // 로또 구매 수량 계산.
        int money = Integer.parseInt(input);
        purchaseQuantity = money / lottoPrice;
    }

    public void outputPurchaseQuantity() {
        OutputView.printPurchaseQuantity(purchaseQuantity);
    }


}
