package lotto.view;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String OUTPUT_PURCHASE_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String ANNOUNCE_THE_START_OF_STATICS = "당첨 통계\n---";
    private static final String OUTPUT_FIRST_RANK_MATCH_COUNT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String OUTPUT_SECOND_RANK_MATCH_COUNT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String OUTPUT_THIRD_RANK_MATCH_COUNT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String OUTPUT_FOURTH_RANK_MATCH_COUNT = "4개 일치 (50,000원) - %d개\n";
    private static final String OUTPUT_FIFTH_RANK_MATCH_COUNT = "3개 일치 (5,000원) - %d개\n";
    private static final String OUTPUT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchasedLottoCount(int lottoCount) {
        System.out.printf(OUTPUT_PURCHASE_LOTTO_COUNT, lottoCount);
    }

    public void printLottoNumbers(ArrayList<List<Integer>> lottoNumbersList) {
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningResultsByRank(Map<Rank, Integer> matchCount) {
        System.out.println(ANNOUNCE_THE_START_OF_STATICS);
        System.out.printf(OUTPUT_FIFTH_RANK_MATCH_COUNT, matchCount.get(Rank.FIFTH));
        System.out.printf(OUTPUT_FOURTH_RANK_MATCH_COUNT, matchCount.get(Rank.FOURTH));
        System.out.printf(OUTPUT_THIRD_RANK_MATCH_COUNT, matchCount.get(Rank.THIRD));
        System.out.printf(OUTPUT_SECOND_RANK_MATCH_COUNT, matchCount.get(Rank.SECOND));
        System.out.printf(OUTPUT_FIRST_RANK_MATCH_COUNT, matchCount.get(Rank.FIRST));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_PROFIT_RATE, profitRate);
    }
}