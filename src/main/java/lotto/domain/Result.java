package lotto.domain;

import java.util.Arrays;
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
        int[] result = new int[ResultType.values().length];
        for (Lotto lotto : purchasedLotto) {
            ResultType resultType = ResultType.getResultType(lotto, winningNumber, bonusBall);
            result[resultType.ordinal()]++;
        }
        return result;
    }

    enum ResultType {
        FIRST(6, false),
        SECOND(5, true),
        THIRD(5, false),
        FOURTH(4, false),
        FIFTH(3, false),
        NONE(0, false);

        private final int matchCount;
        private final boolean hasBonusBall;

        ResultType(int matchCount, boolean hasBonusBall) {
            this.matchCount = matchCount;
            this.hasBonusBall = hasBonusBall;
        }

        public static ResultType getResultType(Lotto lotto, List<Integer> winningNumber, int bonusBall) {

                long matchCount = lotto.getNumbers().stream().filter(winningNumber::contains).count();
                boolean hasBounuBall = lotto.getNumbers().contains(bonusBall);

            return Arrays.stream(values())
                    .filter(type -> type.matchCount == matchCount && type.hasBonusBall == hasBounuBall)
                    .findFirst()
                    .orElse(NONE);
        }
    }
}