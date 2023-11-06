package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int inputBudget() {
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        return InputValidator.validNumber(Console.readLine());
    }
}
