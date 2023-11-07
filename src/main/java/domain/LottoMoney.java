package domain;

import constant.LottoConfig;
import validator.LottoMoneyValidator;

public class LottoMoney {

    private final int money;

    public LottoMoney(){
        this.money = 0;
    }

    public LottoMoney(String money){
       validate(money);
       this.money = Integer.parseInt(money);
    }

    private void validate(String money){
        LottoMoneyValidator.validNumberic(money);
        LottoMoneyValidator.validFitLottoCost(money);
        LottoMoneyValidator.validNotZero(money);
    }

    public int getAvaliablePurcahaseCount(){
       return money/ LottoConfig.COST.getValue();
    }

}
