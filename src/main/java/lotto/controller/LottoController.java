package lotto.controller;

import lotto.model.BuyingMoney;
import lotto.model.CorrectNum;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.view.View;

import java.util.List;

public class LottoController {
    View view = new View();
    LottoList lottoList;
    CorrectNum correctNum;

    public void start(){
        String s = view.inputBuyingMoney();
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            int buyingnum = buyingMoney.buyingMoney;
            lottoList = new LottoList(buyingnum);
            view.BuyingLottoOutput(lottoList.lottoList);
            middle();
        }catch (IllegalArgumentException e){
            view.inputExceptionMessage();
            start();
        }
    }

    public void middle(){
        String s = view.inputCorrectNUM();
        try {
            correctNum = new CorrectNum(s);
            middle2();
        }catch (IllegalArgumentException e){
            view.outputExceptionMessage();
            middle();
        }
    }

    public void middle2(){

    }


}
