package lotto.view;

import java.sql.SQLOutput;

public class OutputView {
    public static final String TICKET_COUNT="개를 구매했습니다.";
    public static final String WINNING_STATICS_MESSAGE="당첨 통계";
    public static void printTicketCnt(int count){
        System.out.println(count+TICKET_COUNT);
    }

    public static void printSuccessResult(){
        System.out.println(WINNING_STATICS_MESSAGE);
        System.out.println("---");
    }

    public static void printRevenueRate(double EarningRate){
        System.out.println("총 수익률은" +String.format("%.1f",EarningRate)+"%입니다.");
    }
    public static void printSuccessMessage(String message, int numberOfMatch){
        System.out.println(message + numberOfMatch +"개");
    }

}
