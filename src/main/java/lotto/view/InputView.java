package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Validator;

public class InputView {
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static int inputBudget() {
        while (true) {
            try {
                System.out.println("구매금액을 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateBudgetInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
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
                System.out.println(INPUT_ERROR_MESSAGE);
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
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
    }
}
