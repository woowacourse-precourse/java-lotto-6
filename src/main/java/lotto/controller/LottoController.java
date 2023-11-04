package lotto.controller;

import static lotto.constant.ExceptionMessage.BONUS_NUMBER_QUANTITY_ERROR;
import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoInfo.BONUS_NUMBER_SIZE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {

    private static final String SPLIT_REGEX = " ";

    public void inputNumbers(String input) {
        validateDuplicateNumber(validateIsNumeric(validateInputSize(input)));
    }

    public void inputBonusNumber(String input) {
        validateInputIsNull(input);
        String[] splitInput = input.split(SPLIT_REGEX);
        validateBonusNumberSize(splitInput);
        validateNumberRange(validateIsNumeric(splitInput));
    }

    private static void validateInputIsNull(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(BONUS_NUMBER_QUANTITY_ERROR.getMessage());
        }
    }

    private static void validateBonusNumberSize(String[] splitInput) {
        if (splitInput.length != BONUS_NUMBER_SIZE.getInfo()) {
            throw new IllegalArgumentException(BONUS_NUMBER_QUANTITY_ERROR.getMessage());
        }
    }

    private String[] validateInputSize(String input) {
        String[] splitInput = input.split(SPLIT_REGEX);
        if (Arrays.stream(splitInput).count() != LOTTO_SIZE.getInfo()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }

        return splitInput;
    }

    private List<Integer> validateIsNumeric(String[] splitInput) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (String inputNumber : splitInput) {
            if (!isNumeric(inputNumber)) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR.getMessage());
            }

            inputNumbers.add(Integer.parseInt(inputNumber));
        }

        return inputNumbers;
    }

    private boolean isNumeric(String inputNumber) {
        for (char inputCh : inputNumber.toCharArray()) {
            if (!Character.isDigit(inputCh)) {
                return false;
            }
        }

        return true;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }

        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (number < MINIMUM_NUMBER.getInfo() || number > MAXIMUM_NUMBER.getInfo()) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        });
    }

}
