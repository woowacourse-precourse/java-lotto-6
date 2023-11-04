package lotto.view;

public class OutputView {

    private static final String LOTTO_PURCHASE_PROMPT = "구입금액을 입력해 주세요.\n";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.\n";

    public static void printLottoPurchasePrompt() {
        System.out.print(LOTTO_PURCHASE_PROMPT);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printWinningNumbersPrompt() {
        System.out.print(WINNING_NUMBERS_PROMPT);
    }

    public static void printBonusNumberPrompt() {
        System.out.print(BONUS_NUMBER_PROMPT);
    }

}
