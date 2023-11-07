package lotto.view;

import java.sql.SQLOutput;

public class OutputView {
    public static final String TICKET_COUNT="개를 구매했습니다.";
    public static final String WINNING_STATICS_MESSAGE="당첨 통계";
    public static void printTicketCnt(int count){
        System.out.println(count+TICKET_COUNT);
    }

    public static void printSucecessResult(){
        System.out.println(WINNING_STATICS_MESSAGE);
        System.out.println("---");
    }

    public static void printSuccessMessage(String message, int numberOfMatch){
        System.out.println(message + numberOfMatch +"개");
    }

}
