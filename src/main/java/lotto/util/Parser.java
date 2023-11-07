package lotto.util;

import static java.util.stream.Collectors.toList;

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
        String[] splitted = input.split(DELIMITER);
        Arrays.stream(splitted)
                .forEach(InputValidator::validateNumberType);

        List<Integer> numbers = Arrays.stream(splitted)
                .map(Integer::parseInt)
                .toList();

        InputValidator.validateLottoNumbers(numbers);
        return new Lotto(numbers);
    }

    public static int parseBonusNumber(String input) {
        InputValidator.validateNumberType(input);
        int bonusNumber = Integer.parseInt(input);
        InputValidator.validateLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

}
