package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parsePurchasePrice(String input) {
        InputValidator.validateNumberType(input);
        int amount = Integer.parseInt(input);
        InputValidator.validatePurchaseAmount(amount);
        return amount;
    }

    public static List<Integer> parseLottoNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .peek(InputValidator::validateNumberType)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        InputValidator.validateLottoNumbers(numbers);
        return numbers;
    }

    public static int parseBonusNumber(String input) {
        InputValidator.validateNumberType(input);
        int bonusNumber = Integer.parseInt(input);
        InputValidator.validateLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

}
