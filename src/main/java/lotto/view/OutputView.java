package lotto.view;

import lotto.utils.PrintingMessage;

public class OutputView {
    public void printGetPurchaseAmountMessage() {
        System.out.println(PrintingMessage.GET_PURCHASE_AMOUNT_MESSAGE.get());
    }

    public void printBuyingMessage(int lottoCount) {
        System.out.println();
        System.out.println(PrintingMessage.BUYING_MESSAGE.getWithFormat(lottoCount));
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public void printGetWinningLottoMessage() {
        System.out.println();
        System.out.println(PrintingMessage.GET_WINNING_NUMBERS_MESSAGE.get());
    }

    public void printGetBonusNumberMessage() {
        System.out.println();
        System.out.println(PrintingMessage.GET_BONUS_NUMBER_MESSAGE.get());
    }

    public void printPrizeMessageStartMessage() {
        System.out.println();
        System.out.println(PrintingMessage.PRIZE_MESSAGE_START_MESSAGE.get());
    }

    public void printPrizeMessages(int sameCount, long prizeProfit, int prizeCount) {
        System.out.println(PrintingMessage.PRIZE_MESSAGE.getWithFormat(sameCount, prizeProfit, prizeCount));
    }

    public void printProfitRate(double profitRate) {
        System.out.println(PrintingMessage.PROFIT_MESSAGE.getWithFormat(profitRate));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
