package lotto.constants;

import java.util.Comparator;

public enum LottoPrize {
    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000);

    private final int matchingNumbers; // 맞아야 하는 숫자 개수
    private final boolean hasMatchingBonusNumber; // 보너스 볼을 맞춰야 하는 여부
    private final int prizeAmount; // 당첨 금액

    LottoPrize(int matchingNumbers, boolean hasMatchingBonusNumber, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.hasMatchingBonusNumber = hasMatchingBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public static Comparator<LottoPrize> lottoPrizeComparator = (rank1, rank2) ->
            rank1.getPrizeAmount() - rank2.getPrizeAmount();

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean getHasMatchingBonusNumber() {
        return hasMatchingBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
