package lotto.domain;

import java.util.List;

public class Result {
    private final List<Lotto> purchasedLotto;
    private final int bonusBall;
    private final List<Integer> winningNumber;

    public Result(List<Lotto> purchasedLotto, List<Integer> winningNumber, int bonusBall) {
        this.purchasedLotto = purchasedLotto;
        this.bonusBall = bonusBall;
        this.winningNumber = winningNumber;
    }

    public int[] checkWinning() {
        int[] result = new int[6];
        for (Lotto lotto : purchasedLotto) {
            int matchCount = countMatchNumber(lotto);
            boolean hasBonusBall = lotto.getNumbers().contains(bonusBall);
        }
        return result;
    }

    private int countMatchNumber(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}