package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PrizeType;

public class Printer {
    private static final String LOTTO_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATICS_MESSAGE = "당첨 통계\n---";
    private static final String REWARD_RATE_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printPurchasedLottoQuantity(long quantity) {
        System.out.printf(LOTTO_PURCHASED_MESSAGE, quantity);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatics(HashMap<PrizeType, Integer> winningHistories) {
        System.out.println(WINNING_STATICS_MESSAGE);

        for (PrizeType prize : PrizeType.getValues()) {
            System.out.println(prize.getStaticsMessage(winningHistories.get(prize)));
        }
    }

    public static void printRewardRate(String rewardRate) {
        System.out.printf(REWARD_RATE_MESSAGE, rewardRate);
    }
}
