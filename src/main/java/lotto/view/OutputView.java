package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLottoStorage;

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
}
