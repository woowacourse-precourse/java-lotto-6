package lotto.view;

import lotto.domain.Result;

import java.util.List;

import static lotto.view.ViewMessage.*;

public class OutputView {

    public static void printNumberOfLotto(int count) {
        System.out.printf(PRINT_PURCHASE_MESSAGE.getMessage(), count);
    }

    public static void printResult(Result result) {
        List<Integer> ranks = result.getRanks();
        System.out.printf(String.valueOf(PRINT_WINNING_STATISTICS_MESSAGE.getMessage())
                , ranks.get(5), ranks.get(4), ranks.get(3), ranks.get(2), ranks.get(1));
    }

    public static void printIncomeRate(double incomeRate) {
        System.out.printf(PRINT_INCOME_RATE_MESSAGE.getMessage(), incomeRate);
    }
}
