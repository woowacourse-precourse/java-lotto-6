package util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println(purchaseAmount + PURCHASE.getMessage());
    }
    public void printWinningStatistic(){
        System.out.println(WINNING_STATISTIC.getMessage());
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

    public void printPurchaseInfo(List<Integer> lottoNums){
        List<Integer> sortLottoNums = new ArrayList<>(lottoNums);
        sortLottoNums.sort(Comparator.naturalOrder());
        StringBuilder lottoNum = new StringBuilder("");

        lottoNum.append("[");
        for (Integer number : sortLottoNums) {
            lottoNum.append(number).append(", ");
        }
        lottoNum.delete(lottoNum.length()-2, lottoNum.length()).append("]");
        System.out.println(lottoNum);
    }

}
