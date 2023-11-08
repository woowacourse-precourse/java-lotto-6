package lotto.view;

import lotto.util.Message;

public class OutputView {

    public void printMessageForInputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printNumberForPurchasedLottos() {
        System.out.println(String.format(Message.NUMBER_OF_TICKET_PURCHASED.getMessage(), 0));

    }
    public void printMessageForWinningNumbers() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }
    public void printMessageForBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printMessageLotteryStatistics() {
        System.out.println(Message.LOTTERY_STATISTICS.getMessage());
        System.out.println("---");
    }
    public void printLotteryStatistics() {
        System.out.println(String.format(Message.MATCH_3.getMessage(), 0));
        System.out.println(String.format(Message.MATCH_4.getMessage(), 0));
        System.out.println(String.format(Message.MATCH_5.getMessage(), 0));
        System.out.println(String.format(Message.MATCH_6.getMessage(), 0));
        System.out.println(String.format(Message.TOTAL_PROFIT_PERCENT.getMessage(), 0));
    }
}
