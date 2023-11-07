package lotto.controller;

import lotto.model.BuyingMoney;
import lotto.model.CorrectNum;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.view.View;

import java.util.List;

public class LottoController {
    View view = new View();


    public void start(){
        String s = view.inputBuyingMoney();
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            int buyingnum = buyingMoney.buyingMoney;
            LottoList lottoList = new LottoList(buyingnum);
            view.BuyingLottoOutput(lottoList.lottoList);
            middle(lottoList.lottoList);
        }catch (IllegalArgumentException e){
            view.inputExceptionMessage();
            start();
        }
    }

    public void middle(List<Lotto> lottoList){
        String s = view.inputCorrectNUM();
        try {
            CorrectNum correctNum = new CorrectNum(s);
        }catch (IllegalArgumentException e){

        }
    }

}
