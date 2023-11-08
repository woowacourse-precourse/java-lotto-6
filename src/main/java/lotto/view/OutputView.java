package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String START_WINNING_STATICS_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printNumberOfPurchasedLotto(int numberOfPurchasedLotto) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE, numberOfPurchasedLotto);
        System.out.println();
    }

    public static void printLottosList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void printStatics(HashMap<Rank, Integer> winningHistories) {
        System.out.println(START_WINNING_STATICS_MESSAGE);

        for (Rank winningHistory : Rank.getValues()) {
            System.out.println(winningHistory.getStaticsMessage(winningHistories.get(winningHistory)));
        }
    }

    public static void printRateOfReturn(String rate) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rate);
    }
}
