package lotto.parser;

import static lotto.condition.LottoCondition.LOTTO_PRICE;
import static lotto.condition.Symbols.DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validator.InputValidator;

public class Parser {
    private Parser() {
    }

    public static List<Integer> parseLotto(final String input) {
        InputValidator.validateEndsWithComma(input);
        List<Integer> parsedNumbers = Arrays.stream(input.split(DELIMITER.getSymbol()))
                .map(Parser::validateEmptyAndParse)
                .toList();
        InputValidator.validateDuplicateNumber(parsedNumbers);
        InputValidator.validateLottoNumberCount(parsedNumbers);
        parsedNumbers.forEach(InputValidator::validateLottoNumberRange);
        return parsedNumbers;
    }

    public static int parseLottoCount(final String input) {
        int parsedAmount = validateEmptyAndParse(input);
        InputValidator.validatePurchaseAmount(parsedAmount);
        return parsedAmount / LOTTO_PRICE.getValue();
    }

    public static Integer parseBonusNumber(final String input) {
        int parsedNumber = validateEmptyAndParse(input);
        InputValidator.validateLottoNumberRange(parsedNumber);
        return parsedNumber;
    }

    private static int validateEmptyAndParse(final String input) {
        InputValidator.validateEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoException.of(ErrorMessage.INVALID_INPUT_TYPE);
        }
    }
}
