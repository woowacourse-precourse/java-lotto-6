package lotto.view;

import lotto.domain.RevenueDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LEFT_LOTTO_BRACKET = "[";
    private static final String RIGHT_LOTTO_BRACKET = "]";

    public static void printLottosByAmount(List<List<Integer>> lottos) {
        for(List<Integer> lotto: lottos) {
            printLottoByAmount(lotto);
        }
    }

    private static void printLottoByAmount(List<Integer> lotto) {
        System.out.println(LEFT_LOTTO_BRACKET);
        String result = String.join(", ", lotto.toString());
        System.out.println(result);
        System.out.println(RIGHT_LOTTO_BRACKET);
    }

    public static void printWinningStatics(HashMap<Integer, Integer> result) {
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(1, 0) + "개");
    }

    public static void printWinningRevenue(RevenueDto revenueDto) {
        double userRateOfRevenue = revenueDto.getUserRateOfRevenue();
        System.out.printf("총 수익률은 %.1f%%입니다.", userRateOfRevenue);
    }

    public static void printWinningStaticsInput() {
        System.out.println("당첨 통계\n---");
    }

}
