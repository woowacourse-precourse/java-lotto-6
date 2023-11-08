package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum LottoPrize {
    FIRST( 2_000_000_000,6,false),
    SECOND( 30_000_000,5,true),
    THIRD( 1_500_000,5,false),
    FOURTH(50_000,4,false),
    FIFTH( 5_000,3,false),
    NONE(0,0,false);
    private final long prizeAmount;
    private final int matchingNumber;
    private final boolean isSecond;

    LottoPrize(long prizeAmount,int matchingNumbers,boolean isSecond) {
        this.prizeAmount = prizeAmount;
        this.matchingNumber = matchingNumbers;
        this.isSecond = isSecond;
    }

    public Long getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public static LottoPrize findRank(int matchingNumber, boolean isSecond){
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.matchingNumber == matchingNumber && lottoPrize.isSecond == isSecond) {
                return lottoPrize;
            }
        }
        return NONE;
    }
    public static List<LottoPrize> lowestPrizeOrder() {
        List<LottoPrize> orderedPrizes = new ArrayList<>(Arrays.asList(LottoPrize.values()));
        orderedPrizes.remove(NONE);
        orderedPrizes.sort(Comparator.comparingLong(LottoPrize::getPrizeAmount));
        return orderedPrizes;
    }


}
