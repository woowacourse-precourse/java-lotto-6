package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidator;

public class InputView {

    private static final String INPUT_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public List<Integer> winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        boolean validInput = false;
        List<Integer> numbers = new ArrayList<>();

        while (!validInput) {
            try {
                String input = Console.readLine();

                InputValidator.validateStringInput(input);

                numbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

                validInput = InputValidator.validateWinningNumInput(numbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numbers;
    }

    public int bonusNumber() {

        System.out.println(INPUT_BONUS_NUMBER);
        boolean validInput = false;
        String input = "";

        while (!validInput) {
            try {

                input = Console.readLine();
                validInput = InputValidator.validateBonusNumInput(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    public int lottoPurchaseCost() {
        boolean validInput = false;
        System.out.println(INPUT_PURCHASE_COST);
        String input = "";

        while (!validInput) {
            try {

                input = Console.readLine();
                validInput = InputValidator.validatePurchaseAmountInput(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }
}
