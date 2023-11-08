package domain;

import constant.ConfigNumber;
import validator.LottoMoneyValidator;

public class LottoMoney {

    private final long money;

    public LottoMoney(){
        this.money = 0;
    }

    public long getMoney() {
        return money;
    }

    public LottoMoney(String money){
       validate(money);
       this.money = Integer.parseInt(money);
    }

    public long getAvaliablePurcahaseCount(){
        return money/ ConfigNumber.COST.getValue();
    }

    private void validate(String money){
        LottoMoneyValidator.validNumberic(money);
        LottoMoneyValidator.validFitLottoCost(money);
        LottoMoneyValidator.validNotZero(money);
    }



}
