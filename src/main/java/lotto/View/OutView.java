package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Util.WinningStatistics;

public class OutView {
    static final String SUCCESFULLY_PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    static final String LOTTO_WINNING_STATISTICS_START_MESSAGE = "\n당첨 통계\n---";

    public static void printPurchasedLottos(List<String> lottoNumbers) {
        System.out.println(lottoNumbers.size() + SUCCESFULLY_PURCHASE_LOTTO_MESSAGE);
        for (String lottoNumber : lottoNumbers) {
            System.out.println("[" + lottoNumber + "]");
        }
    }

    public static void printLottoWinningStatistics(Map<String, Integer> lottoWinningStatistics) {
        System.out.println(LOTTO_WINNING_STATISTICS_START_MESSAGE);
        int index = 3;
        for (WinningStatistics message : WinningStatistics.values()) {
            if (lottoWinningStatistics.get(Integer.toString(index)) == null) {
                System.out.println(message.getMessage() + "0개");
                index++;
                continue;
            }
            System.out.println(message.getMessage() + lottoWinningStatistics.get(Integer.toString(index)) + "개");
            index++;
        }
    }

    public static void printRateOfReturn(double result) {
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
