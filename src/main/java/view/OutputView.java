package view;

import enums.ConstantStringManager;

public class OutputView {

    public void printLottoPriceInputNotify() {
    String message = ConstantStringManager.LOTTO_PRICE_INPUT_NOTIFY.getMessage();
    System.out.println(message);
    }
}
