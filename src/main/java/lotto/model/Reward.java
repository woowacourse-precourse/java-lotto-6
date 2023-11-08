package lotto.model;

import lotto.view.OutputView;

public enum Reward {
    ONE(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    BONUSTWO(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THREE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOUR(4, 50_000, "4개 일치 (50,000원) - "),
    FIVE(3, 5_000, "3개 일치 (5,000원) - "),
    ZERO(0, 0, "");

    private int correct;
    private int awardMoney;
    private String message;
    Reward(int correct, int awardMoney, String message){
        this.correct = correct;
        this.awardMoney = awardMoney;
        this.message = message;
    }
    public static Reward choice(int correct, boolean bonus){
        for (Reward reward : values()){
            if (reward.countCorrect(correct) && reward != BONUSTWO){
                return reward;
            }
        }
        if (BONUSTWO.correct==5 && bonus){
            return BONUSTWO;
        }
        if (correct < 0){
            return ZERO;
        }
        throw new IllegalArgumentException(Valid.ERROR.getErrorMessage());
    }
    public boolean countCorrect(int correct){
        return this.correct == correct;
    }
    public void printMessage(int count){
        OutputView.printRewardMessage(message, count);
    }

    public int getCorrect(){
        return correct;
    }
    public int getAwardMoney(){
        return awardMoney;
    }

}
