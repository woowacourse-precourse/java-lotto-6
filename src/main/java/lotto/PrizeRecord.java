package lotto;

public class PrizeRecord {
    private int firstPlaceLottoCount;
    private int secondPlaceLottoCount;
    private int thirdPlaceLottoCount;
    private int fourthPlaceLottoCount;
    private int fifthPlaceLottoCount;
    private long totalPrize;
    private int moneySpent;
    private double profitRatio;
    private boolean isUptoDate;

    public PrizeRecord() {
        firstPlaceLottoCount = 0;
        secondPlaceLottoCount = 0;
        thirdPlaceLottoCount = 0;
        fourthPlaceLottoCount = 0;
        fifthPlaceLottoCount = 0;
        totalPrize = 0;
        profitRatio = 0.0;
        moneySpent = 0;
        isUptoDate = true;
    }

    /**
     * @param prize 로또 순위
     * @return 의미 없음
     */
    public int accumulate(Prize prize, int lottoPrice) {
        moneySpent += lottoPrice;
        isUptoDate = false;
        if (prize.equals(Prize.FIRST)) {
            return ++firstPlaceLottoCount;
        }
        if (prize.equals(Prize.SECOND)) {
            return ++secondPlaceLottoCount;
        }
        if (prize.equals(Prize.THIRD)) {
            return ++thirdPlaceLottoCount;
        }
        if (prize.equals(Prize.FOURTH)) {
            return ++fourthPlaceLottoCount;
        }
        if (prize.equals(Prize.FIFTH)) {
            return ++fifthPlaceLottoCount;
        }
        return 0;
    }

    public long getTotalPrize() {
        if (isUptoDate) {
            return totalPrize;
        }

        totalPrize
                = (long) Prize.FIRST.value() * firstPlaceLottoCount
                + (long) Prize.SECOND.value() * secondPlaceLottoCount
                + (long) Prize.THIRD.value() * thirdPlaceLottoCount
                + (long) Prize.FOURTH.value() * fourthPlaceLottoCount
                + (long) Prize.FIFTH.value() * fifthPlaceLottoCount;

        return totalPrize;
    }

    public double getProfitRatio() {
        return ((double) getTotalPrize()) / moneySpent;
    }

    public int getFirstPlaceLottoCount() {
        return firstPlaceLottoCount;
    }

    public int getSecondPlaceLottoCount() {
        return secondPlaceLottoCount;
    }

    public int getThirdPlaceLottoCount() {
        return thirdPlaceLottoCount;
    }

    public int getFourthPlaceLottoCount() {
        return fourthPlaceLottoCount;
    }

    public int getFifthPlaceLottoCount() {
        return fifthPlaceLottoCount;
    }
}
