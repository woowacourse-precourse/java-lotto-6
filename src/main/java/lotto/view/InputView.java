package lotto.view;

public class InputView {
    public static final String ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_LOTTO_TICKET_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printEnterBudgetMessage() {
        System.out.println(ENTER_BUDGET_MESSAGE);
    }

    public void printEnterWinningLottoTicketMessage() {
        System.out.println(ENTER_WINNING_LOTTO_TICKET_MESSAGE);
    }

    public void printEnterBonusNumberMessage() {
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
    }

    public void println(String message) {
        System.out.println(message);
    }
}
