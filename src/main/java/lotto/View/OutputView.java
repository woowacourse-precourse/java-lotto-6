package lotto.View;

public class OutputView {
    public static final String TICKET_COUNT = "개를 구매했습니다.";

    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printSuccessResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printFifthMessage(int numberOfMatch) {
        System.out.print("3개 일치 (5,000원) - ");
        System.out.println(numberOfMatch + "개");
    }

    public static void printFourthMessage(int numberOfMatch) {
        System.out.print("4개 일치 (50,000원) - ");
        System.out.println(numberOfMatch + "개");
    }

    public static void printThirdMessage(int numberOfMatch) {
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.println(numberOfMatch + "개");
    }
    public static void printSecondMessage(int numberOfMatch) {
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println(numberOfMatch + "개");
    }
    public static void printFirstMessage(int numberOfMatch) {
        System.out.print("6개 일치 (2,000,000,000원) - ");
        System.out.println(numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
    public static void prinfln(){
        System.out.println();
    }
}