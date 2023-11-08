package lotto.Model;

import lotto.View.OutputView;

public enum WinningResult {

    FAILED(0, "", 0),
    THREE_MATCHED(3, "3개 일치 (5,000원) - ", 5_000),
    FOUR_MATCHED(4, "4개 일치 (50,000원) - ", 50_000),
    FIVE_MATCHED(5, "5개 일치 (1,500,000원) - ", 1_500_000),
    BONUS_MATCHED(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    ALL_MATCHED(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private static final String WRONG_LOTTO_RESULT_ERROR_MESSAGE = "[ERROR] 비정상적인 로또 결과 발생";
    private int matchCount;
    private String winningDescription;
    private int totalPrizeAmount;

    WinningResult(int matchCount, String winningDescription, int totalPrizeAmount) {
        this.matchCount = matchCount;
        this.winningDescription = winningDescription;
        this.totalPrizeAmount = totalPrizeAmount;
    }

    public static WinningResult setResult(int matchCount, boolean bonusNumberCheck) {
        if (matchCount < 3) {
            return FAILED;
        }
        if (BONUS_MATCHED.checkMatchCount(matchCount) && bonusNumberCheck) {
            return BONUS_MATCHED;
        }
        for (WinningResult winningResult : values()) {
            if (winningResult.checkMatchCount(matchCount) && winningResult != BONUS_MATCHED) {
                return winningResult;
            }
        }
        System.out.println(WRONG_LOTTO_RESULT_ERROR_MESSAGE);
        throw new IllegalArgumentException(WRONG_LOTTO_RESULT_ERROR_MESSAGE);
    }

    public int getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    private boolean checkMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public void printMessage(int matchCount) {
        if (this != FAILED) {
            OutputView.printSuccessMessage(winningDescription, matchCount);
        }
    }
}
