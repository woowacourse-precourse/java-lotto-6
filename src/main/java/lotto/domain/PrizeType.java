package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NONE(2, 0);

    private final int matchNumbers;
    private final int money;

    PrizeType(int matchNumbers, int money) {
        this.matchNumbers = matchNumbers;
        this.money = money;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getMoney() {
        return money;
    }

    public static List<PrizeType> getValues() {
        List<PrizeType> prizeTypeValues = Stream.of(PrizeType.values())
                                                        .filter(rankType -> rankType.matchNumbers >= 3)
                                                        .collect(Collectors.toList());
        Collections.reverse(prizeTypeValues);
        return prizeTypeValues;
    }

    public static PrizeType getPrizeType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(PrizeType.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumbers, matchBonus))
                .findAny().orElse(NONE);
    }

    private boolean isRankData(PrizeType rankData, int matchNumbers, boolean matchBonus) {
        if (isSecondPrize(rankData) && matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        } else if (isThirdPrize(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        } else if (!isSecondPrize(rankData) && !isThirdPrize(rankData)) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }

        return false;
    }

    private boolean isSecondPrize(PrizeType rankData) {
        return rankData == SECOND_PRIZE;
    }

    private boolean isThirdPrize(PrizeType rankData) {
        return rankData == THIRD_PRIZE;
    }

    private boolean isMatchNumber(int rankMatchNumbers, int matchNumbers) {
        return rankMatchNumbers == matchNumbers;
    }

    public String getStaticsMessage(int count) {
        if (isSecondPrize(matchNumbers, money)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumbers, money, count);
        }

        return String.format("%d개 일치 (%,d원) - %,d개", matchNumbers, money, count);
    }

    private boolean isSecondPrize(int matchNumbers, int money) {
        return matchNumbers == SECOND_PRIZE.getMatchNumbers() && money == SECOND_PRIZE.getMoney();
    }
}
