package lotto.view;

public class OutputView {
    private final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String WINNIG_STATISTICS_MESSAGE = "당첨 통계\n---";

    protected OutputView() {
    }

    public void display(String message) {
        System.out.println(message);
    }

    public void displayInputPurcaseAmoutMessage() {
        display(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void displayInputWinningNumverMessage() {
        display(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void displayInputBonusNumverMessage() {
        display(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void displayWinningStatisticsMessage() {
        display(WINNIG_STATISTICS_MESSAGE);
    }
}
