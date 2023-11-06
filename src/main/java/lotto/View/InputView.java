package lotto.View;

public class InputView {
    private final InputValidator inputValidator;
    private final String BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final InputView INSTANCE = new InputView(InputValidator.getInstance());

    private InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public void printBuyPriceMessageOnConsole() {
        System.out.println(BUY_PRICE_MESSAGE);
    }
    public void printWinningNumberMessageOnConsole() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }
    public void printBonusNumberMessageOnConsole() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

}
