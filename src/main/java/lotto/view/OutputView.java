package lotto.view;

public class OutputView {
    private OutputView() {
    }

    public static void printBuyLotto(){
        System.out.printf("%d개를 구매했습니다.%n",buyLotto);
    }
    public static void printWin(String win) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(win);
    }
    public static void printProfitRate() {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
