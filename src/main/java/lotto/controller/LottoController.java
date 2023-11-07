package lotto.controller;

import lotto.model.BuyingMoney;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.view.View;

import java.util.List;

public class LottoController {
    View view = new View();


    public void start(){
        String s = view.inputBuyingMoney();
        int buyingnum;
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            buyingnum = buyingMoney.buyingMoney;
            LottoList lottoList = new LottoList(buyingnum);
            view.BuyingLottoOutput(lottoList.lottoList);
        }catch (IllegalArgumentException e){
            view.exceptionMessage();
            start();
        }
    }


}
