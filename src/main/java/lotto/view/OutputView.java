package lotto.view;

import lotto.constant.OutputMessage;

import java.util.List;

public class OutputView {

    public void printRequestMoney() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public void printLottoAmount(int amount) {
        System.out.printf(OutputMessage.PURCHASE_LOTTO.getMessage(), amount);
    }

    public void printRequestLuckyNum() {
        System.out.println(OutputMessage.ENTER_LUCKY_NUMBERS.getMessage());
    }

    public void printRequestBonusNum() {
        System.out.println(OutputMessage.ENTER_BONUS_NUMBER.getMessage());
    }

    public void printMatchResult(List<Integer> winningRank) {
        System.out.printf(OutputMessage.ALERT_MATCH.getMessage(),
                winningRank.get(4), winningRank.get(3), winningRank.get(2), winningRank.get(1), winningRank.get(0));
    }

    public void printRevenueRate(double revenue) {
        System.out.printf(OutputMessage.TOTAL_REVENUE_RATE.getMessage(), revenue);
    }

}
