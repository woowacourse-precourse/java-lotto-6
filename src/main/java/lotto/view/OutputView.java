package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printWinningNumbersPrompt() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
