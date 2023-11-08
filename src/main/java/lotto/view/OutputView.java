package lotto.view;

import lotto.model.Ranking;

import java.util.Map;

import static lotto.constant.NumberConstants.*;
import static lotto.constant.MessageConstants.*;

public class OutputView {


    public static void printLottoAmount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printResult() {
        System.out.println();
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(DIVIDE_MESSAGE);
    }

    public static void printWinning(String message, int matchNumber) {
        System.out.println(message + matchNumber + "개");
    }

    public static void printRANKING(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i --) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }
    public static void printRevenueRate(double EarningRate) {
        System.out.printf(EARNING_RATE_MESSAGE, EarningRate);
    }


    public static void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningMinCount()) / (lottoAmount * LOTTO_PRICE_UNIT)
                            * (result.get(rank)) * (ONE_HUNDRED));
        }
        printRevenueRate(EarningRate);
    }


}