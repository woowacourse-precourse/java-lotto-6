package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrice;
import lotto.model.TotalLotto;
import lotto.util.Message;

public class OutputView {

    public void printMessageForInputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printNumberForPurchasedLottos(LottoPrice lottoPrice) {
        System.out.println(String.format(Message.NUMBER_OF_TICKET_PURCHASED.getMessage(), lottoPrice.getPrice() / 1000));
    }

    public void printPurchasedLottos(TotalLotto totalLotto) {
        for (Lotto lotto : totalLotto.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }

    }
    public void printMessageForWinningNumbers() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }
    public void printMessageForBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printMessageLotteryStatistics() {
        System.out.println(Message.LOTTERY_STATISTICS.getMessage());
    }
    public void printLotteryStatisticsFor_1(int count) {
        System.out.println(String.format(Message.FIRST.getMessage(), count));
    }
    public void printLotteryStatisticsFor_2(int count) {
        System.out.println(String.format(Message.SECOND.getMessage(), count));
    }
    public void printLotteryStatisticsFor_3(int count) {
        System.out.println(String.format(Message.THIRD.getMessage(), count));
    }
    public void printLotteryStatisticsFor_4(int count) {
        System.out.println(String.format(Message.FOURTH.getMessage(), count));
    }
    public void printLotteryStatisticsFor_5(int count) {
        System.out.println(String.format(Message.FIFTH.getMessage(), count));
    }

    public void printTotalProfitPercentage(float percentage) {
        System.out.println(String.format(Message.TOTAL_PROFIT_PERCENT.getMessage(), percentage));
    }

}
