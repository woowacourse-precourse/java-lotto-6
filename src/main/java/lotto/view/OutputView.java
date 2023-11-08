package lotto.view;

public class OutputView {

    public static void printTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printStatistics(double yield) {
        System.out.printf("총 수익률은 %f%%입니다.\n", yield);
    }
}
