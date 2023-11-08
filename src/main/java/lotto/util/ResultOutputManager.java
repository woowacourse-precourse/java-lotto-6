package lotto.util;

import lotto.support.RevenueCalculator;
import lotto.support.Rate;

import java.util.HashMap;
import java.util.List;

public class ResultOutputManager {
    private final String SUMMING_UP = "당첨 통계";
    private final String LINE = "---";
    private final String FIFTH = "3개 일치 (5,000원) - %d개\n";
    private final String FOURTH = "4개 일치 (50,000원) - %d개\n";
    private final String THIRD = "5개 일치 (1,500,000원) - %d개\n";
    private final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private final String FIRST = "6개 일치 (2,000,000,000원) - %d개\n";
    private final String REVENUE = "총 수익률은 %.1f%%입니다.\n";

    private final List<Rate> result;
    private final RevenueCalculator revenueCalculator;


    public ResultOutputManager(List<Rate> result) {
        this.result = result;
        this.revenueCalculator = new RevenueCalculator(result);
    }

    public void print() {
        revenueCalculator.calculate();
        HashMap<String, Integer> count = revenueCalculator.getCount();
        double revenue = revenueCalculator.getRevenue();

        System.out.println(SUMMING_UP);
        System.out.println(LINE);
        System.out.printf(FIFTH, count.getOrDefault("fifth", 0));
        System.out.printf(FOURTH, count.getOrDefault("fourth", 0));
        System.out.printf(THIRD, count.getOrDefault("third", 0));
        System.out.printf(SECOND, count.getOrDefault("second", 0));
        System.out.printf(FIRST, count.getOrDefault("first", 0));
        System.out.printf(REVENUE, revenue);

    }


}
