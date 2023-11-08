package lotto.domain;

import lotto.constants.GameNumberConstants;

public class WinningResult {
    private int[] prize = new int[GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue() + 1];//인덱스 0은 사용x, 인덱스 1의 값은 1등개수

    public WinningResult() {
    }

    public int getNumberOfPrizeFromIndex(int index) {
        return prize[index];
    }

    public void addNumberOfPrizeFromIndex(int index) {
        prize[index]++;
    }
}
