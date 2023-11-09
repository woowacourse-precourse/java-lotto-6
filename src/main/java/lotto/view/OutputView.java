package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningLottoStorage;
import lotto.utils.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.view.OutputMessage.*;

public class OutputView {

    private final Map<Rank, String> rankPrinter;

    public OutputView() {
        rankPrinter = new LinkedHashMap<>();
        initRankPrinter();
    }

    private void initRankPrinter() {
        rankPrinter.put(Rank.CORRECT_THREE, CORRECT_THREE.getMessage());
        rankPrinter.put(Rank.CORRECT_FOUR, CORRECT_FOUR.getMessage());
        rankPrinter.put(Rank.CORRECT_FIVE, CORRECT_FIVE.getMessage());
        rankPrinter.put(Rank.CORRECT_FIVE_BONUS, CORRECT_FIVE_BONUS.getMessage());
        rankPrinter.put(Rank.CORRECT_SIX, CORRECT_SIX.getMessage());
    }

    public void printLottoResult(WinningLottoStorage winningLottoStorage) {
        printWinningStatistics();

        for (Map.Entry<Rank, String> ranks : rankPrinter.entrySet()) {
            Rank rank = ranks.getKey();
            int numberOfItems = getLottoResultByRank(rank, winningLottoStorage);

            System.out.println(formatResultString(rank, numberOfItems));
        }
    }

    private void printWinningStatistics() {
        System.out.println();
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(DIVIDING_LINE.getMessage());
    }

    private String formatResultString(Rank rank, int numberOfItems) {
        String formatString = rankPrinter.get(rank);
        return String.format(formatString, numberOfItems);
    }

    private int getLottoResultByRank(Rank rank, WinningLottoStorage winningLottoStorage) {
        return winningLottoStorage.getRank(rank);
    }

    public void printPurchasedLotto(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(StringUtil.formatRateOfReturn(rateOfReturn));
    }

    public void printNumberOfPurchases(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + BUY_IT.getMessage());
    }
}
