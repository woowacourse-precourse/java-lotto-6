package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    First(6,2000000000,false),
    Second(5, 30000000,true),
    Third(5,1500000,false),
    fourth(4,50000,false),
    Fifth(3,5000,false),
    None(0,0,false);

    private final int correctCount;
    private final int reward;
    private final boolean needToCorrectBonusNumber;

    private Ranking(int correctCount, int reward,boolean needToCorrectBonusNumber) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.needToCorrectBonusNumber = needToCorrectBonusNumber;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getNeedToCorrectBonusNumber(){
        return needToCorrectBonusNumber;
    }

}
