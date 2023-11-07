package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class Parser {
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static int parsePurchasePrice(String input) {
        InputValidator.validateNumberType(input);
        int amount = Integer.parseInt(input);
        InputValidator.validatePurchaseAmount(amount);
        return amount;
    }

    public static Lotto parseLottoNumbers(String input) {
        String[] split = input.split(DELIMITER);
        Arrays.stream(split)
                .forEach(InputValidator::validateNumberType);

        List<Integer> numbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();

        return new Lotto(numbers);
    }

    public static int parseBonusNumber(String input) {
        InputValidator.validateNumberType(input);
        int bonusNumber = Integer.parseInt(input);
        InputValidator.validateLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

}
