package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.validate.Validate;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoList lottoList = new LottoList();
    Validate validate = new Validate();

    public void start(){
        String s = view.inputBuyingMoney();
        try {
            validate.inputBuyingMoneyValidate(s);
        }catch (IllegalArgumentException e){
            view.exceptionMessage();
            start();
        }
    }
}
