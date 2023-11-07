package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidator;
import lotto.util.StringUtils;

public class InputView {
    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요."),
        INPUT_BONUS_NUMBER("\n보너스 번호를 입력해주세요."),
        INPUT_WINNER_NUMBER("\n당첨 번호를 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int inputBudget() {
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        String input = Console.readLine();
        InputValidator.validNumber(input);
        return Integer.parseInt(input);
    }


    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println(ConsoleMessage.INPUT_WINNER_NUMBER.message);

        return StringUtils.splitByComma(Console.readLine()).stream()
                .peek(InputValidator::validNumber)
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String input = Console.readLine();
        InputValidator.validNumber(input);
        return Integer.parseInt(input);
    }
}
