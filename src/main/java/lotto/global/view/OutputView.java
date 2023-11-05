package lotto.global.view;

public class OutputView {

    private static final String ENTER = System.lineSeparator();
    private static final String BUY_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_COUNT_MESSAGE =  ENTER + "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = ENTER + "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = ENTER + "보너스 번호를 입력해 주세요.";

    public static void printBuyLottoMessage() {
        System.out.println(BUY_LOTTO_MESSAGE);
    }

    public static void printPurchasedCountMessage(final int count) {
        System.out.println(String.format(PURCHASED_COUNT_MESSAGE, count));
    }

    public static void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
