package lotto.controller;

import lotto.model.*;
import lotto.view.View;

import java.util.List;

public class LottoController {
    View view = new View();
    LottoList lottoList;
    CorrectNum correctNum;
    BonusNum bonusNum;
    LottoResult lottoResult;

    public void lottogame(){
        start();
        middle();
        middle2();
        end();
    }

    public void start(){
        String s = view.inputBuyingMoney();
        try {
            BuyingMoney buyingMoney = new BuyingMoney(s);
            int buyingnum = buyingMoney.buyingMoney;
            lottoList = new LottoList(buyingnum);
            view.BuyingLottoOutput(lottoList.getLottoList());
        }catch (IllegalArgumentException e){
            view.inputExceptionMessage();
            start();
        }
    }

    public void middle(){
        String s = view.inputCorrectNUM();
        try {
            correctNum = new CorrectNum(s);
        }catch (IllegalArgumentException e){
            view.outputExceptionMessage();
            middle();
        }
    }

    public void middle2(){
        String s = view.inputBonusNum();
        try {
            bonusNum = new BonusNum(s);
        }catch (IllegalArgumentException e){
            view.outputExceptionMessage();
            middle2();
        }
    }

    public void end(){
        for (Lotto lotto : lottoList.getLottoList()) {
            for (int i : lotto.numbers) {

            }
        }
    }
}
