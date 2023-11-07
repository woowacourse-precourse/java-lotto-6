package lotto.view;

import lotto.dto.RevenueDto;
import lotto.dto.PurchaseLottoDto;

import java.util.HashMap;
import java.util.List;

public class OutputView {


    private static final String OUTPUT_ISSUE_ABLE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String COUNT_UNIT = "개";
    private static final String OUTPUT_RATE_OF_REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String OUTPUT_WINNING_STATICS_MESSAGE = "\n당첨 통계\n---";
    private static final int DEFAULT_VALUE = 0;
    private static final String WINNING_STATICS_FIFTH = "3개 일치 (5,000원) - ";
    private static final String WINNING_STATICS_FOUR = "4개 일치 (50,000원) - ";
    private static final String WINNING_STATICS_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String WINNING_STATICS_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_STATICS_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final int FIRST_RANK = 1;
    private static final int SECOND_RANK = 2;
    private static final int THIRD_RANK = 3;
    private static final int FOUR_RANK = 4;
    private static final int FIFTH_RANK = 5;

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottosByAmount(PurchaseLottoDto lottos) {
        for(List<Integer> lotto: lottos.getLottos()) {
            System.out.println(lotto);
        }
        printEnter();
    }

    public static void printIssueAbleCount(int issueAbleCount) {
        printEnter();
        System.out.printf(OUTPUT_ISSUE_ABLE_COUNT_MESSAGE, issueAbleCount);
    }

    public static void printWinningStatics(HashMap<Integer, Integer> result) {
        System.out.println(WINNING_STATICS_FIFTH + result.getOrDefault(FIFTH_RANK, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(WINNING_STATICS_FOUR + result.getOrDefault(FOUR_RANK, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(WINNING_STATICS_THIRD + result.getOrDefault(THIRD_RANK, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(WINNING_STATICS_SECOND + result.getOrDefault(SECOND_RANK, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(WINNING_STATICS_FIRST + result.getOrDefault(FIRST_RANK, DEFAULT_VALUE) + COUNT_UNIT);
    }

    public static void printWinningRevenue(RevenueDto revenueDto) {
        double userRateOfRevenue = revenueDto.getUserRateOfRevenue();
        System.out.printf(OUTPUT_RATE_OF_REVENUE_MESSAGE, userRateOfRevenue);
    }

    public static void printWinningStaticsInput() {
        System.out.println(OUTPUT_WINNING_STATICS_MESSAGE);
    }

    public static void printEnter() {
        System.out.println();
    }

}
