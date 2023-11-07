package domain;

import validator.LottoMoneyValidator;

public class LottoMoney {

    private final long money;

    public LottoMoney(String money){
        LottoMoneyValidator.validate(money);
        this.money = Integer.parseInt(money);
    }

}
