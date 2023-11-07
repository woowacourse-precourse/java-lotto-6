package lotto.domain;

import java.util.List;

public class Result {
    private final List<Lotto> purchasedLotto;
    private final int bonusBall;
    public Result(List<Lotto> purchasedLotto, List<Integer> winningNumber, int bonusBall) {
        this.purchasedLotto = purchasedLotto;
        this.bonusBall = bonusBall;
    }
    public int[] checkWinning() {
        int[] result = new int[6];
        for (Lotto lotto : purchasedLotto) {
            boolean hasBonusBall = lotto.getNumbers().contains(bonusBall);
        }
        return result;
    }
}
