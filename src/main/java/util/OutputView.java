package util;

import lotto.Lotto;

import java.util.Comparator;
import java.util.List;

public class OutputView {
    private static final String PRINT_RESULT = "당첨 통계\n---";
    private static final String FIFTH_PLACE = "3개 일치 (5,000원) - %d개";
    private static final String FORTH_PLACE = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PLACE = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PRINT_STATISTICS = "총 수익률은 %.1f%%입니다.";
    private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.";


    public static void printStatistics(double ratio) {
        System.out.println(String.format(PRINT_STATISTICS, ratio));
    }
    public static void printResult(int[] winCount) {
        System.out.println(PRINT_RESULT);
        System.out.println(String.format(FIFTH_PLACE,winCount[5]));
        System.out.println(String.format(FORTH_PLACE,winCount[4]));
        System.out.println(String.format(THIRD_PLACE,winCount[3]));
        System.out.println(String.format(SECOND_PLACE,winCount[2]));
        System.out.println(String.format(FIRST_PLACE,winCount[1]));
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(String.format(PRINT_LOTTO_COUNT,lottos.size()));
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = lotto.getNumbers();
            //sortedLotto.sort(Comparator.naturalOrder());
            System.out.println(sortedLotto);
        }
    }
}
