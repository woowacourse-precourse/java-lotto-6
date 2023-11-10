package lotto.service;

import static lotto.model.Rank.*;

public class Calculator {

    private static final float PERCENTAGE = 100;
    private static final int TICKET_PRICE = 1000;
    private static final int RANKING_FIRST = 1;
    private static final int RANKING_FIFTH = 5;

    public static int numberOfLottoTickets(int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
    }

    public static float rateOfProfit(int purchasePrice, int[] rankBoard) {
        float totalPrize = totalPrize(rankBoard);
        return (totalPrize / (float) purchasePrice) * PERCENTAGE;
    }

    public static int totalPrize(int[] rankBoard) {
        int total = 0;

        for (int i = RANKING_FIRST; i <= RANKING_FIFTH; i++) {
            total += eachRankPrize(i, rankBoard[i]);
        }

        return total;
    }

    public static int eachRankPrize(int rankNumber, int rateNum) {
        switch (rankNumber) {
            case 5:
                return getPrizeMoney(FIFTH) * rateNum;
            case 4:
                return getPrizeMoney(FOURTH) * rateNum;
            case 3:
                return getPrizeMoney(THIRD) * rateNum;
            case 2:
                return getPrizeMoney(SECOND) * rateNum;
            case 1:
                return getPrizeMoney(FIRST) * rateNum;
        }
        return 0;
    }
}
