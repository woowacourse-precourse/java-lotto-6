package lotto.common;

import static lotto.common.InfoMessage.*;

import java.text.NumberFormat;
import java.util.List;

public enum LottoPlace {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    OUT_OF_RANK(0, 0);

    private final int matchingNum;
    private final int reward;

    LottoPlace(int matchingNum, int reward) {
        this.matchingNum = matchingNum;
        this.reward = reward;
    }

    public int getMatchingNum() {
        return matchingNum;
    }

    public int getReward() {
        return reward;
    }

    public static LottoPlace getPlaceCount(int matchingNum, boolean isBonusNumMatch) {
        List<LottoPlace> places = List.of(values());
        if (matchingNum == 5) {
            return isBonusFive(isBonusNumMatch);
        }
        return places.get(matchingNum);
    }

    public static LottoPlace isBonusFive(boolean isBonusNumMatch) {
        if (isBonusNumMatch) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }



    @Override
    public String toString() {
        String reward = NumberFormat.getInstance().format(getReward());

        if(this == LottoPlace.SECOND_PLACE) {
            return String.format(WINNING_SECOND_PLACE_OUTPUT.getMessage(), getMatchingNum(), reward);
        }
        return String.format(WINNING_PLACE_OUTPUT.getMessage(), getMatchingNum(), reward);
    }

}
