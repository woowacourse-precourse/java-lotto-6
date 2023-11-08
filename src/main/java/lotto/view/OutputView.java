package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {

    private static final String PURCHASE_LOTTO_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String PRIZE_RATIO_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottoQuantity(int lottoQuantity) {
        String message = String.format(PURCHASE_LOTTO_QUANTITY_MESSAGE, lottoQuantity);
        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLotteryResult(EnumMap<LottoRank, Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DELIMITER);

        for (Map.Entry<LottoRank, Integer> rank : lottoResult.entrySet()) {
            LottoRank lottoRank = rank.getKey();
            String message = String.format(lottoRank.getMessage(), lottoRank.getMatchCount(), lottoRank.getWinningAmount(), rank.getValue());

            System.out.println(message);
        }
    }

    public void printPrizeRatio(double ratio) {
        String message = String.format(PRIZE_RATIO_MESSAGE, ratio);
        System.out.println(message);
    }
}
