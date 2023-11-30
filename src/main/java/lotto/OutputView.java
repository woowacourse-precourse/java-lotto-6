package lotto;

public class OutputView {


    public static void printTicketCount(int count) {
        System.out.println(count + Global.BUY_HOW_MANY);
    }

    public static void printSuccessResult() {
        System.out.println(Global.WINNING_STATICS);
        System.out.println(Global.SLASH);
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
