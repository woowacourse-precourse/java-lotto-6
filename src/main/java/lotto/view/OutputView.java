package lotto.view;

import lotto.utils.PrintingMessage;

public class OutputView {
    public void printGetPurchaseAmountMessage() {
        System.out.println(PrintingMessage.GET_PURCHASE_AMOUNT_MESSAGE.get());
    }

    public void printBuyingMessage(int lottoCount) {
        System.out.println(PrintingMessage.BUYING_MESSAGE.getWithFormat(lottoCount));
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public void printGetWinningNumbersMessage() {
        System.out.println(PrintingMessage.GET_WINNING_NUMBERS_MESSAGE.get());
    }

    public void printGetBonusNumberMessage() {
        System.out.println(PrintingMessage.GET_BONUS_NUMBER_MESSAGE.get());
    }
}
