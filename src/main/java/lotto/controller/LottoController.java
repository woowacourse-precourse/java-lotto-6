package lotto.controller;

import lotto.model.BuyingMoney;
import lotto.model.LottoList;
import lotto.view.View;

public class LottoController {
    View view = new View();


    public void start(){
        String s = view.inputBuyingMoney();
        int buyingnum;
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            buyingnum = buyingMoney.buyingMoney;
            LottoList lottoList = new LottoList(buyingnum);
        }catch (IllegalArgumentException e){
            view.exceptionMessage();
            start();
        }
    }


}
