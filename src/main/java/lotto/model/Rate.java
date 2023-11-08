package lotto.model;

import java.util.HashMap;


public class Rate {
    private static final int lottoPrice = 1000;
    public static int purchaseTicket(int price) {
        return price / lottoPrice;
    }

    public static double calculateRateOfReturn(HashMap<Rank, Integer> result, Price price){
        int sumPrize = calSumPrize(result);
        double rate = calRate(sumPrize, price.getPrice());
        return rate;
    }

    public static int calSumPrize(HashMap<Rank, Integer> result) {
        int sum = 0;
        for (Rank rank : result.keySet()){
            sum += (rank.getPrize() * result.get(rank));
        }
        return sum;
    }

    public static double calRate(int resultSum, int price){
        return ((double) resultSum/(price)) * 100;
    }
}
