package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.Validator;

public class InputView {

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validateIsDigit(input);
                int purchaseAmount = Integer.parseInt(input);
                Validator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<String> splitInput = List.of(input.split(","));
                Validator.validateStringLotto(splitInput);
                List<Integer> numbers = splitInput.stream().map(Integer::parseInt).toList();
                Validator.validateLotto(numbers);
                return numbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validateIsDigit(input);
                int bonusNumber = Integer.parseInt(input);
                Validator.validateNumberRange(bonusNumber);
                Validator.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
