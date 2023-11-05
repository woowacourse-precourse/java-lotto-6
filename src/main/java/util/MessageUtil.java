package util;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static constant.InputMessage.*;
import static constant.OutputMassage.*;
import static constant.ResultMessage.FIVE_WITH_BONUS;

public class MessageUtil {
    public void printPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT.getMessage());
    }
    public void printWinningNum(){
        System.out.println(WINNING_NUM.getMessage());
    }
    public void printBonusNum(){
        System.out.println(BONUS_NUM.getMessage());
    }

    public void printPurchase(int purchaseAmount){
        System.out.printf(PURCHASE.getMessage(), purchaseAmount);
    }
    public void printWinningStatistic(){
        System.out.printf(WINNING_STATISTIC.getMessage());
    }
    public void printWinningResult(int matchNum, int price, int num){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String priceComma = decimalFormat.format(price);
        if(matchNum == FIVE_WITH_BONUS.getMatchNumber()){
            System.out.printf(WINNING_BONUS_RESULT.getMessage(), priceComma, num);
            return;
        }
        System.out.printf(WINNING_RESULT.getMessage(), matchNum, priceComma, num);
    }
    public void printWinningRate(Double rate){
        System.out.printf(WINNING_RATE.getMessage(), rate);
    }

    public void printPurchaseInfo(List<Integer> lottoNum){
//        System.out.print("[");
        Collections.sort(lottoNum);
        System.out.println(lottoNum.toString());
//        for(List)
    }

}
