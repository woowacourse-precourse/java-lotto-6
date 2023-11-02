package lotto.view;

public class InputView {
    public static final String ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_LOTTO_TICKET = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String enterBudgetMessage() {
        return ENTER_BUDGET_MESSAGE;
    }

    public static String enterWinningLottoTicket() {
        return ENTER_WINNING_LOTTO_TICKET;
    }

    public static String enterBonusNumber() {
        return ENTER_BONUS_NUMBER;
    }
}
