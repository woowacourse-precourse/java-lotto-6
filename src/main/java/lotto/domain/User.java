package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.LOTTO_PRICE;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MAX;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MONEY;
import static lotto.constant.GeneralConstant.PRIZE_RANK_INDEXES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.MoneyValidator;

public enum User {
    INSTANCE;
    private static final LottoWallet lottoWallet = new LottoWallet();
    private static List<Integer> prizeCounts = new ArrayList<Integer>();
    private static int cost;
    private static long revenue;
    private static double rateOfReturn;

    public static void purchaseLotto(int money) {
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
        revenue = ZERO;
        calcRevenue();
        rateOfReturn = ((double) revenue / cost) * 100;
    }

    private static void calcRevenue() {
        for(int i = ZERO; i < PRIZE_RANK_MAX; i++) {
            String rank = PRIZE_RANK_INDEXES.get(i);
            revenue += (long) prizeCounts.get(i) * PRIZE_RANK_MONEY.get(rank);
        }
    }

    public static double getRateOfReturn() {
        return rateOfReturn;
    }

    public static List<Lotto> getMyLotto() {
        return lottoWallet.getLottos();
    }

    public static List<Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
