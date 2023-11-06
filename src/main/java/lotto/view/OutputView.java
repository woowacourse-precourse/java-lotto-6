package lotto.view;

import lotto.domain.Result;

import java.util.List;

public class OutputView {
    static final String PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public static void printNumberOfLotto(int count) {
        System.out.println("\n" + count + PURCHASE_OUTPUT_MESSAGE);
    }

    public static void printResult(Result result) {
        List<Integer> ranks = result.getRanks();
        System.out.printf("\n당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - %d개\n"
                        + "4개 일치 (50,000원) - %d개\n"
                        + "5개 일치 (1,500,000원) - %d개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                        + "6개 일치 (2,000,000,000원) - %d개\n"
                , ranks.get(5), ranks.get(4), ranks.get(3), ranks.get(2), ranks.get(1));
    }

    public static void printIncomeRate(double incomeRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", incomeRate);
    }
}
