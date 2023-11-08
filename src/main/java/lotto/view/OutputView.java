package lotto.view;

import static lotto.message.MessageConstants.NEW_LINE;
import static lotto.message.MessageConstants.ONE_HUNDRED;
import static lotto.message.MessageConstants.OUTPUT_PURCHASED_COUNT_MESSAGE;
import static lotto.message.MessageConstants.OUTPUT_TOTAL_PROFIT_RATE_MESSAGE;
import static lotto.message.MessageConstants.OUTPUT_WINNING_STATISTICS_MESSAGE;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.LottoBuyer;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;

public class OutputView {
    public void lottoPurchaseCountMessage(int count) {
        System.out.printf(OUTPUT_PURCHASED_COUNT_MESSAGE, count);
    }

    public void lottoNumbersMessage(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void winningHistoryMessage(LottoBuyer lottoBuyer) {
        String winningHistory = getWinningHistory(lottoBuyer);
        String message = String.format(OUTPUT_WINNING_STATISTICS_MESSAGE, winningHistory);

        System.out.println(message);
    }

    private static String getWinningHistory(LottoBuyer lottoBuyer) {
        return Arrays.stream(WinningRank.values())
                .map(winningRank -> winningRank.getMessage(lottoBuyer))
                .collect(Collectors.joining(NEW_LINE));
    }

    public void TotalReturnRateMessage(LottoBuyer lottoBuyer, int inputPrice) {
        double totalPrizeMoney = calculateTotalPrizeMoney(lottoBuyer) / inputPrice * ONE_HUNDRED;
        System.out.printf(OUTPUT_TOTAL_PROFIT_RATE_MESSAGE, totalPrizeMoney);
    }

    private double calculateTotalPrizeMoney(LottoBuyer lottoBuyer) {
        return Arrays.stream(WinningRank.values())
                .mapToDouble(winningRank -> calculateIndividualPrizeMoney(winningRank, lottoBuyer))
                .sum();
    }

    private int calculateIndividualPrizeMoney(WinningRank winningRank, LottoBuyer lottoBuyer) {
        return winningRank.getPrizeMoney() * lottoBuyer.getWinCount(winningRank);
    }
    
}
