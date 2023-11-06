package lotto.domain;

import static lotto.config.LottoConfig.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final String NUMBER_DELIMITER = ",";
    private final String input;

    InputParser(String input) {
        InputValidator.validateEmpty(input);
        this.input = input;
    }

    public int parsePurchasePrice() {
        purchasePriceValidate(this.input);
        return Integer.parseInt(this.input);
    }

    public List<Integer> parseWinningNumbers() {
        winningNumbersValidate(this.input);
        return Arrays.stream(this.input.split(NUMBER_DELIMITER))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    public int parseBonusNumber(List<Integer> winningNumbers) {
        bonusNumberValidate(winningNumbers, this.input);
        return Integer.parseInt(this.input);
    }

    private void purchasePriceValidate(String inputPrice) {
        InputValidator.validateNumeric(inputPrice);
        InputValidator.validateRemainderZero(inputPrice, LOTTO_UNIT_PRICE.getNumber());
    }

    private void winningNumbersValidate(String inputNumbers) {
        InputValidator.validateDelimiterFormat(inputNumbers, NUMBER_DELIMITER, LOTTO_NUMBER_COUNT.getNumber());

        String[] numbers = inputNumbers.split(NUMBER_DELIMITER);
        Arrays.stream(numbers)
                .forEach(InputValidator::validateNumeric);

        Arrays.stream(numbers)
                .forEach(number ->
                        InputValidator.validateNumberInRange(number, LOTTO_NUMBER_MIN.getNumber(), LOTTO_NUMBER_MAX.getNumber())
                );

        InputValidator.validateDuplicateNumber(List.of(numbers));
    }

    private void bonusNumberValidate(List<Integer> numbers, String inputNumber) {
        InputValidator.validateNumeric(inputNumber);
        InputValidator.validateExistNumber(numbers, Integer.parseInt(inputNumber));
        InputValidator.validateNumberInRange(inputNumber, LOTTO_NUMBER_MIN.getNumber(), LOTTO_NUMBER_MAX.getNumber());
    }
}
