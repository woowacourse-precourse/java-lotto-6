package lotto.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoPrize {

    FIFTH_PRIZE(3, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    SECOND_PRIZE(5, 30000000),
    FIRST_PRIZE(6, 2000000000);

    private final Integer matchedNumberCount;
    private final Integer prizeMoney;

    LottoPrize(Integer matchedNumberCount, Integer prizeMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(Boolean hasBonusNumber, Integer countMatchNumber) {
        if (hasBonusNumber && countMatchNumber == 5) {
            return SECOND_PRIZE;
        }

        if (!hasBonusNumber && countMatchNumber == 5) {
            return THIRD_PRIZE;
        }

        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.getMatchedNumberCount().equals(countMatchNumber))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 보너스 넘버와 로또에 맞는 등수가 없습니다."));
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public Integer getMatchedNumberCount() {
        return matchedNumberCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchedNumberCount).append("개 일치");
        if (checkSecondPrize()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(String.format("%,d", prizeMoney)).append("원)");
        return stringBuilder.toString();
    }


    private boolean checkSecondPrize() {
        return prizeMoney.equals(LottoPrize.SECOND_PRIZE.getPrizeMoney())
                && matchedNumberCount.equals(LottoPrize.SECOND_PRIZE.matchedNumberCount);
    }
}
