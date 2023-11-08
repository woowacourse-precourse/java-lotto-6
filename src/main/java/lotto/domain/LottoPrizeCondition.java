package lotto.domain;

import java.util.Objects;

/**
 * @author 민경수
 * @description lotto prize condition
 * @since 2023.11.07
 **********************************************************************************************************************/
public class LottoPrizeCondition {

    private final Integer matchNumbersCount;
    private final Boolean matchBonusBall;

    public LottoPrizeCondition(Integer matchNumbersCount, Boolean matchBonusBall) {
        this.matchNumbersCount = matchNumbersCount;
        this.matchBonusBall = matchBonusBall;
    }

    public static LottoPrizeCondition of(int matchNumbersCount, Boolean matchBonusBall) {
        return new LottoPrizeCondition(matchNumbersCount, matchBonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPrizeCondition that = (LottoPrizeCondition) o;
        return Objects.equals(matchNumbersCount, that.matchNumbersCount) && Objects.equals(
                matchBonusBall, that.matchBonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchNumbersCount, matchBonusBall);
    }

    public Integer matchNumbersCount() {
        return matchNumbersCount;
    }

    public Boolean matchBonusBall() {
        return matchBonusBall;
    }
}