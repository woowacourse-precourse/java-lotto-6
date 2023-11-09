package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import lotto.validator.InputNumberValidator;
import lotto.validator.InputNumbersValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.LottoPurchaseValidator;

public class InputView {

    private InputView() {
    }

    private static <T> T getInput(Function<String, T> converter, Function<T, Boolean> validator) {
        while (true) {
            try {
                String input = Console.readLine();
                T result = converter.apply(input);
                if (validator.apply(result)) {
                    return result;
                } else {
                    System.out.println("[ERROR] Invalid input");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static int inputPurchaseAmount() {
        return getInput(
                Integer::parseInt,
                input -> {
                    InputNumberValidator.validate(String.valueOf(input));
                    LottoPurchaseValidator.validatePurchase(input);
                    return true;
                }
        );
    }

    public static List<Integer> inputWinningNumbers() {
        return getInput(
                input -> Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList(),
                input -> {
                    InputNumbersValidator.validate(input.stream().map(String::valueOf).toList());
                    LottoNumbersValidator.validateLotto(input);
                    return true;
                }
        );
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        return getInput(
                Integer::parseInt,
                input -> {
                    InputNumberValidator.validate(String.valueOf(input));
                    LottoNumbersValidator.validateBonus(winningNumbers, input);
                    return true;
                }
        );
    }
}
