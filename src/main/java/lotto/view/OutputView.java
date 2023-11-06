package lotto.view;

import lotto.model.Statistic;

import java.util.List;

import static lotto.constant.PrintMessage.*;

public class OutputView {
    public static void inputPurchaseAmountMessage(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printIssuedLottoMessage(int issuedLottoCount){
        System.out.println("\n"+issuedLottoCount+PRINT_ISSUED_LOTTO);
    }

    public static void printIssuedLotto(List<Integer> issuedLottoNumber){
        System.out.println(issuedLottoNumber);
    }

    public static void inputWinningNumbersMessage(){
        System.out.println("\n"+INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumberMessage(){
        System.out.println("\n"+INPUT_BONUS_NUMBER);
    }

    public static void winningStatisticMessage(){
        System.out.println("\n"+WINNING_STATISTIC);
    }

    public static void printMatchingCounts(List<Integer> matchingCounts){
        Statistic[] values = Statistic.values();
        for(int i=0; i<values.length; i++){
            System.out.println(values[i].printCount(matchingCounts.get(i)));
        }
    }

    public static void printTotalReturnRate(String returnRate){
        System.out.println("총 수익률은 "+returnRate+"%입니다.");
    }

    public static void errorMessage(String s){
        System.out.println("[ERROR] "+s);
    }
}
