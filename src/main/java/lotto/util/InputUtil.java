package lotto.util;

public class InputUtil {

    private static final InputUtil instance = new InputUtil();
    private final Validator validator = new Validator();

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance;
    }

    public int inputMoney() {
        return 0;
    }

    public String inputWinningNumbers() {
        return "";
    }

    public int inputBonusNumber() {
        return 0;
    }

}
