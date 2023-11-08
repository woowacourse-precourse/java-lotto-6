package lotto;

import java.text.DecimalFormat;

public class Result {
    private final Double investment;

    Result(int investment){
        this.investment = (double)investment;
    }

    String calculateEarningRate(int[] ranking){
        Double profits = (double)calculateTotal(ranking);
        Double value = (profits/investment)*100;
        DecimalFormat formatPercentage = new DecimalFormat("0.0%");
        String percentage = formatPercentage.format(value);
        return percentage;
    }

    private int calculateTotal(int[] ranking){
        int sum = 0;
        sum += (Win.FIVE.getPrize()) * ranking[5];
        sum += (Win.FOUR.getPrize()) * ranking[4];
        sum += (Win.THREE.getPrize()) * ranking[3];
        sum += (Win.TWO.getPrize()) * ranking[2];
        sum += (Win.ONE.getPrize()) * ranking[1];
        return sum;
    }

    public void printRanking(int[] ranking){
        System.out.printf("%s%d%s%n",Win.FIVE.getStr(), ranking[5], "개");
        System.out.printf("%s%d%s%n",Win.FOUR.getStr(), ranking[4], "개");
        System.out.printf("%s%d%s%n",Win.THREE.getStr(), ranking[3], "개");
        System.out.printf("%s%d%s%n",Win.TWO.getStr(), ranking[2], "개");
        System.out.printf("%s%d%s%n",Win.ONE.getStr(), ranking[1], "개");
    }
}
