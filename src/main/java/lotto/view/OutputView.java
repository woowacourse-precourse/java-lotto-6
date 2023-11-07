package lotto.view;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printLottoPurchaseMessage() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
    }

    public void printLineSeparator() {
        System.out.println();
    }

    public void printLottoCountMessage(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printWinningNumberMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
