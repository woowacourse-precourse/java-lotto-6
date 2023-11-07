package lotto.view;

import java.sql.SQLOutput;

import static lotto.view.Message.*;

public class OutputView {

    public static void printTicketCnt(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printSuccessResult() {
        System.out.println(WINNING_STATICS_MESSAGE);
        System.out.println("---");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

}
