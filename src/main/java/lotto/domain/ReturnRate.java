package lotto.domain;

public class ReturnRate {

    private static final int ZERO = 0;
    private static final double PERCENTAGE = 100.0;

    private double returnRate = 0.0;
    private int sumOfMoney = 0;

    public ReturnRate(Compare scoreResult, User user) {
        for(Score score : Score.values()) {
            sumOfMoney(scoreResult, score);
        }
        this.returnRate = (double)sumOfMoney/(double)user.getMoney() * PERCENTAGE;
    }

    private void sumOfMoney(Compare scoreResult, Score score) {
        if(scoreResult.getScoreResult(score) > ZERO && score != Score.NULL) {
            sumOfMoney += score.getMoney() * scoreResult.getScoreResult(score);
        }
    }

    public double getReturnRate() {
        return returnRate;
    }
}
