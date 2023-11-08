package lotto.view;

import static lotto.domain.WinningCriteria.SECOND;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningCriteria;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String START_WINNING_STATICS_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_RESULT = "%d개 일치 (%,d원) - %d개";
    private static final String LOTTO_SECOND_RESULT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public static void printNumberOfLottoPurchase(int quantity) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_MESSAGE, quantity);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatics(HashMap<WinningCriteria, Integer> result) {
        System.out.println(START_WINNING_STATICS_MESSAGE);

        WinningCriteria[] winningCriteria = WinningCriteria.values();
        for (int i = winningCriteria.length - 2; i >= 0; i--) {
            int count = getMatchCount(result, winningCriteria[i]);
            System.out.println(getStaticsMessage(winningCriteria[i].getMatchCount(),
                    winningCriteria[i].getPrize(), count));
        }
    }

    private static int getMatchCount(HashMap<WinningCriteria, Integer> result, WinningCriteria type) {
        if (result.containsKey(type)) {
            return result.get(type);
        }
        return 0;
    }

    private static String getStaticsMessage(int matchCount, int prize, int count) {
        if (prize == SECOND.getPrize()) {
            return String.format(LOTTO_SECOND_RESULT, matchCount, prize, count);
        }
        return String.format(LOTTO_RESULT, matchCount, prize, count);
    }

    public static void printRateOfReturn(double rate) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rate);
    }
}
