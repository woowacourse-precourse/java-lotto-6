package lotto.domain;

import lotto.constants.GameNumberConstants;

public class LottoResult {
    private int[] prize = new int[GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue() + 1];

    public LottoResult() {
    }

    public int getNumberOfPrizeFromIndex(int index) {
        return prize[index];
    }

    public void addNumberOfPrizeFromIndex(int index) {
        prize[index]++;
    }
}
