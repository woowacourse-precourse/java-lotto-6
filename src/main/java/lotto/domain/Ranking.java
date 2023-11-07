package lotto.domain;

public enum Ranking {

    None(0, 0, false, ""),
    Fifth(3, 5000, false, "3개 일치 (5,000원) - "),
    Fourth(4, 50000, false, "4개 일치 (50,000원) - "),
    Third(5, 1500000, false, "5개 일치 (1,500,000원) - "),
    Second(5, 30000000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    First(6, 2000000000, false, "6개 일치 (2,000,000,000원) - ");

    private final int correctCount;
    private final int reward;
    private final boolean needToCorrectBonusNumber;
    private final String message;

    private Ranking(int correctCount, int reward, boolean needToCorrectBonusNumber, String message) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.needToCorrectBonusNumber = needToCorrectBonusNumber;
        this.message = message;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getNeedToCorrectBonusNumber() {
        return needToCorrectBonusNumber;
    }

    public String getMessage() {
        return message;
    }

}
