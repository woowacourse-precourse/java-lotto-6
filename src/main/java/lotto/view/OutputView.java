package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningLottoStorage;
import lotto.utils.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class OutputView {

    private final Map<Rank, String> rankPrinter;

    public OutputView() {
        rankPrinter = new LinkedHashMap<>();
        initRankPrinter();
    }

    private void initRankPrinter() {
        rankPrinter.put(Rank.CORRECT_THREE, "3개 일치 (5,000원) - %d개");
        rankPrinter.put(Rank.CORRECT_FOUR, "4개 일치 (50,000원) - %d개");
        rankPrinter.put(Rank.CORRECT_FIVE, "5개 일치 (1,500,000원) - %d개");
        rankPrinter.put(Rank.CORRECT_FIVE_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개");
        rankPrinter.put(Rank.CORRECT_SIX, "6개 일치 (2,000,000,000원) - %d개");
    }

    public void printLottoResult(WinningLottoStorage winningLottoStorage) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Map.Entry<Rank, String> ranks : rankPrinter.entrySet()) {
            Rank rank = ranks.getKey();
            int numberOfItems = getLottoResultByRank(rank, winningLottoStorage);

            System.out.println(formatResultString(rank, numberOfItems));
        }
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
        System.out.println(StringUtil.doubleToString(rateOfReturn));
    }

    public void printNumberOfPurchases(int purchaseCount) {
        System.out.println("\n" + purchaseCount + "개를 구매했습니다.");
    }
}
