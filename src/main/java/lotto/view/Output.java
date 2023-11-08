package lotto.view;

public class Output {
    private final static String SHOW_COUNT = "개를 구매했습니다.";
    private final static String SHOW_CALCULATE = "당첨 통계";
    private final static String BAR = "---";
    private final static String TOTAL_PROFIT = "총 수익률은 ";
    private final static String ENDDING = "%입니다";

    public static void show_Ticket_Count(int count) {
        System.out.println();
        System.out.println(count + SHOW_COUNT);
    }

    public static void show_Calcultate() {
        System.out.println();
        System.out.println(SHOW_CALCULATE);
        System.out.println(BAR);
    }

    public static void show_Winning_Status(String message, int count) {
        System.out.println(message + count + "개");
    }

    public static void show_Profit_Rate(double rate) {
        System.out.println(TOTAL_PROFIT + String.format("%.1f", rate) + ENDDING);
    }
}
