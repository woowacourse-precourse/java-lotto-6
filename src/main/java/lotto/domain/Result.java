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
        int totalPrize = calculateTotalPrize(winningCount);
        int totalCost = purchasedLotto.size() * Purchase.LOTTO_PRICE;


        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(ResultType.values())
                .filter(resultType -> resultType != ResultType.NONE)
                .forEach(resultType -> resultType.printWinningResult(winningCount[resultType.ordinal()]));

        double profitRate = ((double) totalPrize - totalCost) / totalCost * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private int calculateTotalPrize(int[] winningCount) {
        int totalPrize = 0;

        for (ResultType resultType : ResultType.values()) {
            totalPrize += resultType.prize * winningCount[resultType.ordinal()];
        }

        return totalPrize;
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
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        NONE(0, false, 0);

        private final int matchCount;
        private final boolean hasBonusBall;
        private final int prize;

        ResultType(int matchCount, boolean hasBonusBall, int prize) {
            this.matchCount = matchCount;
            this.hasBonusBall = hasBonusBall;
            this.prize = prize;
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