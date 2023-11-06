package lotto.domain;

public class LottoChecker {
    private static int rewardAmount;
    private static final int SIX_CORRECT = 2000000000;
    private static final int FIVE_CORRECT_AND_BONUS = 30000000;
    private static final int FIVE_CORRECT = 1500000;
    private static final int FOUR_CORRECT = 50000;
    private static final int THREE_CORRECT = 5000;

    private int[] rankCount = new int[5];

    public int checkReward(Lotto myNumber, Lotto winNumber, int bonusNumber){
        LottoValidator lottoValidator = new LottoValidator(myNumber, winNumber,bonusNumber);

        int cnt = lottoValidator.compareNumber();
        if (cnt == 6) {
            rewardAmount +=  SIX_CORRECT;
            rankCount[4] ++;
        } else if (cnt == 5 && lottoValidator.isBonus()) {
            rewardAmount += FIVE_CORRECT_AND_BONUS;
            rankCount[3] ++;
        }else if ((cnt == 5)){
            rewardAmount += FIVE_CORRECT;
            rankCount[2] ++;
        } else if (cnt == 4) {
            rewardAmount += FOUR_CORRECT;
            rankCount[1] ++;
        } else if (cnt ==3) {
            rewardAmount += THREE_CORRECT;
            rankCount[0] ++;
        }
        return rewardAmount;
    }

    public int[] getRankCount(){
        return rankCount;
    }

}
