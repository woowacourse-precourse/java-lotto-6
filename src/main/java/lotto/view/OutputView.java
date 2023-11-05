package lotto.view;

public class OutputView {
    private final static String INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.\n";
    private final static String PURCHASE_MSG = "%d개를 구매했습니다.\n";
    private final static String INPUT_LOTTO_NUMBER_MSG = "당첨 번호를 입력해 주세요.\n";
    private final static String INPUT_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.\n";
    private final static String WINNING_STATISTICS_MSG = "당첨 통계\n" + "---\n";
    private final static String WINNING_RESULT_MSG = "%d개 일치 (%d원) - %d개";
    private final static String TOTAL_PROFIT_RATE_MGS = "총 수익률은 %.2f%%입니다.\n";

    public static void printInputPurchaseAmountMsg() {
        System.out.print(INPUT_PURCHASE_AMOUNT_MSG);
    }
    public static void printPurchaseMsg(int lottoCount) {
        System.out.printf(PURCHASE_MSG, lottoCount);
    }
    private static void printLotto(int[] lotto) {
        System.out.println("[" + String.join(", ",
                java.util.Arrays.stream(lotto)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)) + "]");
    }
    public static void printLottos(int[][] lottos) {
        for (int[] lotto : lottos) {
            printLotto(lotto);
        }
    }
    public static void printInputWinningNumberMsg() {
        System.out.print(INPUT_LOTTO_NUMBER_MSG);
    }
    public static void printInputBonusNumberMsg() {
        System.out.print(INPUT_BONUS_NUMBER_MSG);
    }
}
