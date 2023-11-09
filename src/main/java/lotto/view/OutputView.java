package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printTicketCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }
    public void printLottoNumber(List<Integer> lotto){
        System.out.println(lotto);
    }

    public static void printSuccessMessage(String message, int numberOfMatch){
        System.out.println(message + numberOfMatch + "개");

    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }

    public static void printSuccessResult(){
        System.out.println("당첨 통계");
        System.out.println("---");

    }

}
