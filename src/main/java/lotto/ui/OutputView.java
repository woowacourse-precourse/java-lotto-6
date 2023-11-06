package lotto.ui;

public class OutputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = """
        당첨 통계
        ---
        """;

    public OutputView() {
    }

    public void printInputPriceMessage() {
        System.out.println(INPUT_PRICE_MESSAGE);
    }

    public void printInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printBoughtLottoNumbers() {
    }

    public void printStatistics() {
        System.out.println(STATISTICS_MESSAGE);
    }
}
