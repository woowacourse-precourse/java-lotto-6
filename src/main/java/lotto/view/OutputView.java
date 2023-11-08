package lotto.view;

import lotto.constants.Ranks;
import lotto.util.ConvertorUtil;

import java.util.List;

import static lotto.constants.OutputMessages.*;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printIssuedLottoes(
            Integer lottoCount,
            List<String> messages
    ) {
        printBuyLottoCount(lottoCount);
        printBuyLottoes(messages);
    }

    private void printBuyLottoes(List<String> messages) {
        messages.forEach(System.out::println);
    }

    private void printBuyLottoCount(int count) {
        System.out.println(INPUT_BUY_AMOUNT.makeMessage(String.valueOf(count)));
    }

    public void printMatchResult(Ranks ranks, String count) {
        System.out.println(WIN_STATISTICS.makeMessage(""));
        if (isMatchBonus(ranks, count)) return;
        System.out.println(
                MATCH_NUMBER.makeMessage(String.valueOf(ranks.getMatchLottoCount())) +
                MATCH_MONEY.makeMessage(ConvertorUtil.convertToStringFormat(ranks.getMoney())) +
                MATCH_COUNT.makeMessage(String.valueOf(count))       
        ); 
    }

    private static boolean isMatchBonus(Ranks ranks, String count) {
        if (ranks == Ranks.SECOND) {
            System.out.println(
                    MATCH_NUMBER.makeMessage(String.valueOf(ranks.getMatchLottoCount())) +
                    MATCH_BONUS.makeMessage("") +
                    MATCH_MONEY.makeMessage(ConvertorUtil.convertToStringFormat(ranks.getMoney()))  +
                    MATCH_COUNT.makeMessage(String.valueOf(count))
            );
            return true;
        }
        return false;
    }

    public void printProfit(String profit) {
        System.out.println(PROFIT_RATE.makeMessage(profit));
    }
}
