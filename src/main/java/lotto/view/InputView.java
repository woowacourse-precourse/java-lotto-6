package lotto.view;

public class InputView {

    private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";
    private static final String ENTER_MAIN_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_LOTTO = "\n보너스 번호를 입력해 주세요.";

    private final Writer writer;

    public InputView(final Writer writer) {
        this.writer = writer;
    }

    public String enterMoney() {
        System.out.println(ENTER_MONEY);

        return writer.getInput();
    }

    public String enterLotto() {
        System.out.println(ENTER_MAIN_LOTTO);

        return writer.getInput();
    }

    public String enterBonusNumber() {
        System.out.println(ENTER_BONUS_LOTTO);

        return writer.getInput();
    }

    public void close() {
        writer.close();
    }
}
