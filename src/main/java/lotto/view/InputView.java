package lotto.view;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return reader.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return reader.readLine();
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return reader.readLine();
    }
}
