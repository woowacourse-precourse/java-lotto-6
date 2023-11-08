package view;

import domain.Rank;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static final String PURCHASE_COMPLETION = System.lineSeparator()
            .concat("%d개를 구매했습니다.")
            .concat(System.lineSeparator());
    public static final String STATISTICS_HEADER = System.lineSeparator()
            .concat("당첨 통계")
            .concat(System.lineSeparator())
            .concat("---");
    public static final String BONUS_BALL_MATCH = "%d개 일치, 보너스 볼 일치 (%s원) - %d개".concat(System.lineSeparator());
    public static final String LOTTO_MATCH = "%d개 일치 (%s원) - %d개".concat(System.lineSeparator());
    public static final String LOTTO_RETURNS = "총 수익률은 %.1f%%입니다.";

    public static void lottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printRankResult(HashMap<Rank, Integer> map, Rank rank) {
        if (rank.getMatch() == 0) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf(BONUS_BALL_MATCH,
                    rank.getMatch(),
                    rank.getStringPrize(),
                    map.get(rank));
            return;
        }
        System.out.printf(LOTTO_MATCH, rank.getMatch(), rank.getStringPrize(), map.get(rank));
    }

    public static void printAllRankResult(HashMap<Rank, Integer> map) {
        for (Rank rank : Rank.values()) {
            printRankResult(map, rank);
        }
    }
}
