package lotto.ui;

import static lotto.constants.Message.PURCHASE_COMMENT;
import static lotto.constants.Message.RESULT;
import static lotto.constants.Message.PROFIT;

import lotto.Lotto;

import java.util.List;

import lotto.constants.Result;

public class OutputView {
    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printLotto(List<Lotto> myLotto) {
        System.out.printf(PURCHASE_COMMENT.getMessage(), myLotto.size());
        for (Lotto lotto : myLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(List<Integer> prizeCount, float profitPercent) {
        System.out.println(RESULT.getMessage());
        for (Result result : Result.values()) {
            System.out.printf(result.getMessage(), prizeCount.get(result.ordinal()));
        }
        System.out.printf(PROFIT.getMessage(), profitPercent);
    }
}
