package lotto.domain;

public class RateOfReturn {
    
    private double rateOfReturn;
    private long reward;

    public RateOfReturn(long purchase) {
        rateOfReturn = purchase*1000;
    }

    public void setReward(long winning){
        reward += winning;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(){
        rateOfReturn = (reward/rateOfReturn)*100;
    }

    public double getReward() {
        return reward;
    }
}
