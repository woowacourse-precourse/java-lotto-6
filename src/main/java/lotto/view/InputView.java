package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public int getPurchaseAmount() {
        String input = readLine();

        return Integer.parseInt(input);
    }

    public String getLottoResult() {
        String input = readLine();
        Validator.validateLottoResult(input);

        return input;
    }

    public int getBonusNumber() {
        return Integer.parseInt(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
