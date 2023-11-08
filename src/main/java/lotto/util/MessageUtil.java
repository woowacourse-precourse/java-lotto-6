package lotto.util;

import static lotto.enums.message.InputMessage.*;
import static lotto.enums.message.OutputMessage.*;
import static lotto.enums.LottoWinningResult.FIVE_WITH_BONUS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MessageUtil {

    public void printBuyInput(){
        System.out.println(BUY_INPUT.getMessage());
    }
    public void printWinningInput(){
        System.out.println(WINNING_INPUT.getMessage());
    }
    public void printBonusInput(){
        System.out.println(BONUS_INPUT.getMessage());
    }
    public void printLottoNums(List<Integer> lottoNums){
        List<Integer> sortLottoNums = new ArrayList<>(lottoNums);
        sortLottoNums.sort(Comparator.naturalOrder());

        StringBuilder strNum = new StringBuilder("");
        strNum.append("[");
        for(Integer num : lottoNums){
            strNum.append(lottoNums).append(", ");
        }
        strNum.delete(strNum.length()-2, strNum.length()).append("]");

        System.out.println(strNum);
    }
    public void printWinningStat(){
        System.out.println(WINNING_STATISTICS);
    }
    public void printWinningStatResult(int rank, int price, int matchCount){
        String priceComma = String.format("%,d", price);
        if(rank == FIVE_WITH_BONUS.getNumber()){
            System.out.printf(WINNING_STATISTICS_BONUS_RESULT.getMessage(), rank, price);
            return;
        }
        System.out.printf(WINNING_STATISTICS_RESULT.getMessage(), rank, price);
    }

}
