package lotto.view;

import static lotto.domain.ErrorMessage.BONUS_INPUT_ERROR;
import static lotto.domain.ErrorMessage.BUDGET_INPUT_ERROR;
import static lotto.domain.ErrorMessage.WINNING_INPUT_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Validator;

public class InputView {
    public static int inputBudget() {
        while (true) {
            try {
                System.out.println("구매금액을 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateBudgetInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(BUDGET_INPUT_ERROR.getMessage() + '\n');
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해주세요.");
                String input = Console.readLine();
                Validator.validateWinningNumbersInput(input);
                return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(WINNING_INPUT_ERROR.getMessage());
            }
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateBonusNumber(winningNumbers, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(BONUS_INPUT_ERROR.getMessage());
            }
        }
    }
}
