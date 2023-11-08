package lotto.view;

public class OutputView {
    public static final String PRINT_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";


    public static void printTicketCount(int ticketCount) {
        System.out.println("\n"+ticketCount + PRINT_TICKET_COUNT_MESSAGE);
    }
    public static void printBoughtLottos(String boughtLottos){
        System.out.println(boughtLottos);
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        /*
        enum 로직 없어서 추후 구현
         */
    }
    public static void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
