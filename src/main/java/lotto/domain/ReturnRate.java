package lotto.domain;

public class ReturnRate {

    private static final int ZERO = 0;

    private double returnRate = 0.0;
    private int sumOfMoney = 0;

    public ReturnRate(Compare scoreResult, User user) {
        for(Score score : Score.values()) {
            sumOfMoney(scoreResult, score);
        }
        this.returnRate = (double)sumOfMoney/user.getMoney();
    }

    private void sumOfMoney(Compare scoreResult, Score score) {
        if(scoreResult.getScoreResult(score) > ZERO && score != Score.NULL) {
            sumOfMoney += score.getMoney();
        }
    }

    public double getReturnRate() {
        return returnRate;
    }
}
