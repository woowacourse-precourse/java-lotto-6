package lotto.view;

import lotto.service.Statistics;

import java.util.Arrays;

public class Result {
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String BAR = "---";
    private static final String CORRECT_MESSAGE = "%s%d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printResult(RankResult rankResult, Statistics statistics) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(BAR);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .forEach(rank -> System.out.println(getCountResult(rank, rankResult)));
        System.out.println(getProfitResult(statistics));
    }

    private String getCountResult(Rank rank, RankResult rankResult) {

            return String.format(CORRECT_MESSAGE
                    , rank.getMessage()
                    , rankResult.getCount(rank));

    }

    private String getProfitResult(Statistics statistics) {
        return String.format(TOTAL_PROFIT_MESSAGE,
                statistics.getRate());
    }


}
