package lotto.controller;

import java.util.HashMap;

public class Statistic {
    public static int calLottoCount(int price, int lottoPrice) {
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
