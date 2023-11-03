package lotto.view;

public class InputView {
    public static final String ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_LOTTO_TICKET_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String enterBudgetMessage() {
        return ENTER_BUDGET_MESSAGE;
    }

    public String enterWinningLottoTicket() {
        return ENTER_WINNING_LOTTO_TICKET_MESSAGE;
    }

    public String enterBonusNumber() {
        return ENTER_BONUS_NUMBER_MESSAGE;
    }
}
