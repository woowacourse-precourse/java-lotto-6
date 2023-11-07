package domain;

import validator.LottoMoneyValidator;

public class LottoMoney {

    private final long money;

    public LottoMoney(String money){
       validate(money);
       this.money = Integer.parseInt(money);
    }

    private void validate(String money){
        LottoMoneyValidator.validate(money);
    }

}
