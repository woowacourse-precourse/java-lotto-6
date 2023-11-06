package lotto.utils;

import java.text.DecimalFormat;

public enum WinningRank {
    OUT_OF_RANK(0, 0),
    FIFTH(Match.THREE.getValue(), GameConstants.FIFTH_PRIZE_AMOUNT),
    FOURTH(Match.FOUR.getValue(), GameConstants.FOURTH_PRIZE_AMOUNT),
    THIRD(Match.FIVE.getValue(), GameConstants.THIRD_PRIZE_AMOUNT),
    SECOND(Match.FIVE.getValue(), GameConstants.SECOND_PRIZE_AMOUNT),
    FIRST(Match.SIXTH.getValue(), GameConstants.FIRST_PRIZE_AMOUNT);

    private int matchingNumberCount;
    private int winningAmount;


    WinningRank(int matchingNumberCount, int winningAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.winningAmount = winningAmount;
    }

    private int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }


    @Override
    public String toString() {
        String formattedAmount = getFormattedAmount();
        if (this == SECOND) {
            return getMatchingNumberCount() + "개 일치, 보너스 볼 일치 (" + formattedAmount + ")";
        }
        return getMatchingNumberCount() + "개 일치, (" + formattedAmount + ")";
    }

    private String getFormattedAmount() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(getWinningAmount());
    }
}