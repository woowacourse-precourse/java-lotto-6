package lotto;

import java.util.Arrays;

public enum WinningRank {
    NO_LUCK(0, 0, false, "꽝.."),
    FIFTH_WINNER(3, 5_000, false, "3개 일치 (5,000원) - %d개\n"),
    FOURTH_WINNER(4, 50_000, false, "4개 일치 (50,000원) - %d개\n"),
    THIRD_WINNER(5, 1_500_000, false, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND_WINNER(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    JACKPOT(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int count;
    private final int reward;
    private final boolean matchedBonusNumber;
    private final String message;

    WinningRank(int count, int reward, boolean matchedBonusNumber, String message){
        this.count = count;
        this.reward = reward;
        this.matchedBonusNumber = matchedBonusNumber;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public String getMessage() {return message;}

    public static WinningRank findWinningRank(int matchCount, boolean bonusNumberCorrect){
        return Arrays.stream(values()).filter(winningRank ->
            winningRank.getCount() == matchCount && bonusNumberCorrect == winningRank.isMatchedBonusNumber()
        ).findFirst().orElse(NO_LUCK);
    }
}
