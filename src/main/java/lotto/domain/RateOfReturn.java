package lotto.domain;

public class RateOfReturn {
    
    private double rateOfReturn;
    private long reward;

    /**
     * 로또 구입 금액을 1000을 곱해서 저장
     */
    public RateOfReturn(long purchase) {
        rateOfReturn = purchase*1000;
    }

    /**
     * 로또 당첨 금액 저장
     */
    public void setReward(long winning){
        reward += winning;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    /**
     * 로또 수익률 계산
     */
    public void setRateOfReturn(){
        rateOfReturn = (reward/rateOfReturn)*100;
    }

}
