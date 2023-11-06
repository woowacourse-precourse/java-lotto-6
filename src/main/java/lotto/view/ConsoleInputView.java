package lotto.view;

public class ConsoleInputView implements InputView {

    private static final String ASK_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private ConsoleInputView() {
    }

    private static class ConsoleInputViewHolder {
        private static ConsoleInputView consoleInputView = new ConsoleInputView();
    }

    public static ConsoleInputView getInstance() {
        return ConsoleInputViewHolder.consoleInputView;
    }

    @Override
    public String askPurchasePrice() {
        print(ASK_PURCHASE_PRICE_MESSAGE);
        return getInput();
    }

    @Override
    public String askWinningNumbers() {
        print(ASK_WINNING_NUMBERS_MESSAGE);
        return getInput();
    }

    @Override
    public String askBonusNumber() {
        print(ASK_BONUS_NUMBER_MESSAGE);
        return getInput();
    }
}
