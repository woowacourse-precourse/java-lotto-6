package lotto.service;

import lotto.util.Validator;


public class LottoService {



    public int initMoneyToCount(String inputMoney) {
        int money = Validator.isNumber(inputMoney);
        return Validator.isDivide(money);
    }



}
