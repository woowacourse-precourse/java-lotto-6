package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public enum User {
    INSTANCE;
    private static final int LOTTO_PRICE = 1000;
    private static LottoWallet lottoWallet = new LottoWallet();
    private static List<Integer> prizeCounts = new ArrayList<Integer>();

    public static void purchaseLotto(int money) {
        lottoWallet.addLotto(money / LOTTO_PRICE);
    }

    public static void plusPrizeCount(int prizeRank) {
        int count = prizeCounts.get(prizeRank);
        prizeCounts.set(prizeRank, count + 1);
    }

    public static List<Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
