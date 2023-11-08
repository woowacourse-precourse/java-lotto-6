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

    public void printResult() {
        int[] winningCount = checkWinning();

        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(ResultType.values())
                .filter(resultType -> resultType != ResultType.NONE)
                .forEach(resultType -> resultType.printWinningResult(winningCount[resultType.ordinal()]));
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
        private final int prize;

        ResultType(int matchCount, boolean hasBonusBall) {
            this.matchCount = matchCount;
            this.hasBonusBall = hasBonusBall;
            this.prize = calculatePrize();
        }

        private int calculatePrize() {
            return 0;
        }

        public static ResultType getResultType(Lotto lotto, List<Integer> winningNumber, int bonusBall) {

            long matchCount = lotto.getNumbers().stream().filter(winningNumber::contains).count();
            boolean hasBonusBall = lotto.getNumbers().contains(bonusBall);

            return Arrays.stream(values())
                    .filter(type -> type.matchCount == matchCount && type.hasBonusBall == hasBonusBall)
                    .findFirst()
                    .orElse(NONE);
        }

        public void printWinningResult(int count) {
            System.out.printf("%d개 일치 (%,d원) - %d개%n", this.matchCount, this.prize, count);

        }
    }
}