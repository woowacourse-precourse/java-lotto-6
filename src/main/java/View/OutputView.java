package View;

public class OutputView {
    public static void promptPurchaseAmount() {
        System.out.println("\n구매금액을 입력해 주세요");
    }

    public static void promptPrizeNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void promptBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void promptWinStatistics() {
        System.out.println("\n당청 통계");
        System.out.println("---");
    }

    public static void printWinResult(String message) {
        System.out.println(message);
    }

    public static void printReturnOfRate(double returnRate) {
        System.out.printf("총 수익률은 %.2f입니다\n", returnRate);
    }

}
