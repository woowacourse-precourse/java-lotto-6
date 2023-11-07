package lotto.view;

public class Output {
    private static final String inputPurchaseAmount = "구입금액을 입력해 주세요.";
    private static final String countLotto = "개를 구매했습니다";
    private static final String inputWinningNumber = "당첨 번호를 입력해 주세요.";
    private static final String inputBonusNumber = "보너스 번호를 입력해 주세요.";
    private static final String printStatistics = "당첨 통계";
    private static final String printEnter = "\n";

    public static void inputPurchaseAmount() {
        System.out.println(inputPurchaseAmount);
    }

    public static void printLottoCount(int count) {
        System.out.println(printEnter + count + countLotto);
    }

    public static void inputWinningNumber() {
        System.out.println(printEnter + inputWinningNumber);
    }

    public static void inputBonusNumber() {
        System.out.println(printEnter + inputBonusNumber);
    }

    public static void statistics() {
        System.out.println(printEnter + printStatistics);
        System.out.println("---");
    }

    public static void result_match(String matchMessage, int matchCount) {
        System.out.println(matchMessage + matchCount + "개");
    }

    public static void total_EarningRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
