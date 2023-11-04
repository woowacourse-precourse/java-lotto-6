package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.MoneyValidator;

public enum User {
    INSTANCE;
    private static final int ZERO = 0;
    private static final int PRIZE_RANK_MAX = 5;
    private static final int LOTTO_PRICE = 1000;
    private static final List<Integer> PRIZE_MONEY = List.of(5000, 50000, 1500000, 30000000, 2000000000);
    private static LottoWallet lottoWallet = new LottoWallet();
    private static List<Integer> prizeCounts = new ArrayList<Integer>();
    private static int cost;
    private static double rateOfReturn;

    public static void purchaseLottos(int money) {
        cost = money;
        MoneyValidator.validateMoney(money);
        clearPrizeCounts();
        lottoWallet.addLotto(money / LOTTO_PRICE);
    }

    private static void clearPrizeCounts() {
        prizeCounts = new ArrayList<>(Collections.nCopies(PRIZE_RANK_MAX, ZERO));
    }

    public static void plusPrizeCount(int prizeRank) {
        int count = prizeCounts.get(prizeRank);
        prizeCounts.set(prizeRank, count + 1);
    }

    public static void calcRateOfReturn() {
        long revenue = 0;
        for(int i = ZERO; i < PRIZE_RANK_MAX; i++) {
            revenue += (long) prizeCounts.get(i) * PRIZE_MONEY.get(i);
        }
        rateOfReturn = ((double) revenue / cost) * 100;
    }

    public static double getRateOfReturn() {
        return rateOfReturn;
    }

    public static List<Lotto> getLottos() {
        return lottoWallet.getLottos();
    }

    public static List<Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
