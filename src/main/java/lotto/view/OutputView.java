package lotto.view;

import java.util.Map;

public class OutputView {
    public static void printWinningResult(Map<String, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("--");
        System.out.printf("%d개 일치 (%s원) - %d개\n", 3, "5,000", result.get("5th"));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 4, "50,000", result.get("4th"));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 5, "1,500,000", result.get("3rd"));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", 5, "30,000,000", result.get("2nd"));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 6, "2,000,000,000", result.get("1st"));
    }

    public static void printGetMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGetWinningNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printGetBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printCommonString(String string) {
        System.out.println(string);
    }

    public static void printLottoCount(int money) {
        System.out.printf("\n%d개를 구매했습니다.\n", money);
    }

    public static void printLottoProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}