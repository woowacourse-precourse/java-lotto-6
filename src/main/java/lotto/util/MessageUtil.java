package lotto.util;

import lotto.constant.message.ErrorOutMessage;
import lotto.constant.message.InputMessage;
import lotto.constant.message.OutPutMessage;

public class MessageUtil {

    public void printPurchaseInput() {
        System.out.println(InputMessage.PURCHASE.getMessage());
    }

    public void printWinningInput() {
        System.out.println(InputMessage.WINNING.getMessage());
    }

    public void printBonusInput() {
        System.out.println(InputMessage.BONUS.getMessage());
    }

    public void printPurchaseError() {
        System.out.println(ErrorOutMessage.PURCHASE);
    }

    public void printWinningTypeError() {
        System.out.println(ErrorOutMessage.WINNING_TYPE);
    }

    public void printWinningDuplicateError() {
        System.out.println(ErrorOutMessage.WINNING_DUPLICATE);
    }

    public void printLottoNumError() {
        System.out.println(ErrorOutMessage.LOTTO_NUM);
    }

    public void printPurchaseCount() {
        System.out.println(OutPutMessage.PURCHASE_COUNT.getMessage());
    }

    public void printWinningStats() {
        System.out.println(OutPutMessage.WINNING_STATS.getMessage());
    }

    public void printWinningStatsResult(int matchCount, int amount, int lottoCount) {
        System.out.printf(OutPutMessage.WINNING_STATS_RESULT.getMessage(), matchCount, amount, lottoCount);
    }

    public void printEarningRate(Double rate) {
        System.out.printf(OutPutMessage.EARNING_RATE.getMessage(), rate);
    }

}
