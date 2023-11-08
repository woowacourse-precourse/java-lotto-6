package lotto.controller;

import lotto.model.*;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoList lottoList;
    CorrectNum correctNum;
    BonusNum bonusNum;
    LottoCalculator lottoCalculator = new LottoCalculator();
    BuyingMoney buyingMoney;


    public void lottogame(){
        start();
        middle();
        middle2();
        end();
    }

    public void start(){
        String s = view.inputBuyingMoney();
        try {
            buyingMoney = new BuyingMoney(s);
            int buyingnum = buyingMoney.buyingMoney;
            lottoList = new LottoList(buyingnum);
            view.BuyingLottoOutput(lottoList.getLottoList(),buyingnum/1000);
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
        lottoResult();
        view.outputResultMessage(lottoCalculator.getCounts());
        double num = lottoCalculator.earningPercentage(buyingMoney.buyingMoney);
        view.outputEarningResultMessage(num);
    }

    private void lottoResult() {
        for (Lotto lotto : lottoList.getLottoList()) {
            int count = 0;
            boolean bsnum = false;
            if(lotto.getNumbers().contains(bonusNum.getBonusNum())){
                bsnum = true;
            }
            for (Integer i : correctNum.getCorrectNum()) {
                if(lotto.getNumbers().contains(i)){
                    count++;
                }
            }
            lottoCalculator.lottoCalculator(count,bsnum);
        }
    }
}
