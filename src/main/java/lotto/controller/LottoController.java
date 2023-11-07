package lotto.controller;

import lotto.model.BuyingMoney;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.validate.Validate;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoList lottoList = new LottoList();


    public void start(){
        String s = view.inputBuyingMoney();
        int buyingnum;
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            buyingnum = buyingMoney.buyingMoney;
        }catch (IllegalArgumentException e){
            view.exceptionMessage();
            start();
        }


    }


}
