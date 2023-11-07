package lotto.view;

public class OutputView {
    private static final String LOTTO_PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printLottoPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_INPUT_MESSAGE);
    }

    public void printLottoPurchaseCountMessage(int LottoPurchaseCount) {
        System.out.println(LottoPurchaseCount + LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
}
