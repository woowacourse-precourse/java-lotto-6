package view;

import enums.ConstantStringManager;

public class OutputView {

    public void printLottoPriceInputNotify() {
    String message = ConstantStringManager.LOTTO_PRICE_INPUT_NOTIFY.getMessage();
    System.out.println(message);
    }

    public void printLottoNumberNotify(int number) {
        String message = ConstantStringManager.LOTTO_NUMBER_NOTIFY.getMessage();
        System.out.printf(message, number);
    }

    public void printWinningNumberInputNotify() {
        String message = ConstantStringManager.WINNING_NUMBER_INPUT_NOTIFY.getMessage();
        System.out.println(message);
    }

    public void printBonusNumberInputNotify() {
        String message = ConstantStringManager.BONUS_NUMBER_INPUT_NOTIFY.getMessage();
        System.out.println(message);
    }
}
