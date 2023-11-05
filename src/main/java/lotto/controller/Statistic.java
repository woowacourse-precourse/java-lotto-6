package lotto.controller;

import java.util.HashMap;

public class Statistic {
    private static final int lottoPrice = 1000;
    public static int calLottoCount(int price) {
        return price / lottoPrice;
    }

    public static int calSumPrize(HashMap<Rank, Integer> result) {
        int sum = 0;
        for (Rank rank : result.keySet()) {
            sum += (rank.getPrize()*result.get(rank));
        }
        return sum;
    }

    public static double calRate(int resultSum, int price) {
        return ((double)resultSum/(price))*100;
    }

}
