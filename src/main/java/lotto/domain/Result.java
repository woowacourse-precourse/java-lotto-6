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

            ResultType resultType = ResultType.getResultType(matchCount, hasBonusBall);
            result[resultType.ordinal()]++;
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

        public static ResultType getResultType(int matchCount, boolean hasBonusBall) {
            for (ResultType resultType : values()) {
                if (resultType.matchCount == matchCount && resultType.hasBonusBall == hasBonusBall) {
                    return resultType;
                }
            }
            return NONE;
        }
    }

}