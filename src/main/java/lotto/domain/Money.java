package lotto.domain;

import lotto.util.Error;

public class Money {

    private final int money;

    public Money(int money){
        validateZero(money);
        validateIsDivision(money);
        this.money = money;
    }

    public int divide1000(){
        return money / 1000;
    }

    private void validateZero(int money){
        if(money == 0){
            throw new IllegalArgumentException(Error.MONEY_ZERO_ERROR.message());
        }
    }

    private void validateIsDivision(int money){
        if(money % 1000 != 0 ){
            throw new IllegalArgumentException(Error.MONEY_DIVIDE_ERROR.message());
        }
    }

    public double rateOfReturn(int[] lottoRank){
        double sum = 0;
        for(int rank=1;rank<=5;rank++){
            if(rank==1) sum += 200000000 * lottoRank[rank];
            if(rank==2) sum += 30000000 * lottoRank[rank];
            if(rank==3) sum += 1500000 * lottoRank[rank];
            if(rank==4) sum += 50000 * lottoRank[rank];
            if(rank==5) sum += 5000 * lottoRank[rank];
        }
        return (sum / money) * 100;

    }
}
