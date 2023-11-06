package lotto.view;

import lotto.domain.Calculator;
import lotto.domain.Result;

import java.util.List;

public class OutputView {
    static final String PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public static void printNumberOfLottoPurchase(int count) {
        System.out.println("\n" + count + PURCHASE_OUTPUT_MESSAGE);
    }

    public static void printResult(Result result) {
        List<Integer> ranks = result.getRanks();
        System.out.println("\n당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + ranks.get(5));
        System.out.println("4개 일치 (50,000원) - " + ranks.get(4));
        System.out.println("5개 일치 (1,500,000원) - " + ranks.get(3));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks.get(2));
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks.get(1));
    }

    public static void printIncomeRate(Calculator calculator, Result result){
        double incomeRate = calculator.calculateIncomeRate(result);
        System.out.printf("총 수익률은 %.2f%%입니다.", incomeRate);
    }
}
