package lotto.util.validator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.util.consts.ErrorMessage.NOT_NUMBER_INPUTTED;
import static lotto.util.consts.ErrorMessage.TOO_LARGE_NUMBER;

public class InputValidator {
    private static final int MEMORY_SIZE_LIMIT = 2100000000;
    private static final String NUMBER_SPLITTER = ",";

    public int parseValidatedInt(String numberMessage) {
        int resultNumber = 0;
        try {
            resultNumber = Integer.parseInt(numberMessage);
            validateMemorySizeLimit(resultNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUTTED.getMessage(), e);
        }
        return resultNumber;
    }

    private void validateMemorySizeLimit(int number) {
        if (number >= MEMORY_SIZE_LIMIT) {
            throw new IllegalArgumentException(TOO_LARGE_NUMBER.getMessage());
        }
    }

    public List<Integer> validateWinNumbers(String numbersMessage) {
        List<Integer> validatedWinNumbers = parseValidatedNumbers(numbersMessage);
        new Lotto(validatedWinNumbers); // 로또 번호 검증 역할 로또 도메인에게 위임
        return validatedWinNumbers;
    }

    private List<Integer> parseValidatedNumbers(String numbersMessage) {
        List<Integer> validatedNumbers = new ArrayList<>();
        Arrays.stream(numbersMessage.split(NUMBER_SPLITTER))
                .map(String::trim)
                .mapToInt(this::parseValidatedInt)
                .forEach(validatedNumbers::add);
        return validatedNumbers;
    }
}