package lotto.view;

import java.util.List;

public interface OutputView {

    void printMoneyRequestMessage();

    void printPurchasedLottos(List<List<Integer>> lottos);

    void printWinningNumberRequestMessage();

    void printBonusNumberRequestMessage();

    void printWinningStatistics(int firstPrizeWinners, int secondPrizeWinners, int thirdPrizeWinners,
                                int fourthPrizeWinners, int fifthPrizeWinners);

    void printTotalProfit(long totalPrize, long money);

    void printErrorMessage(String message);
}
