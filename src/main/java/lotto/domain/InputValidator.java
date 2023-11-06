package lotto.domain;

import lotto.config.ErrorMessage;

import java.util.List;

public class InputValidator {


    public static void validateEmpty(String number) {
        if(number.isEmpty() || number.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.getMessage());
        }
    }
    public static void validateNumeric(String number) {
        if(!number.matches("^[\\d]*$")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
        }
    }

    public static void validateRemainderZero(String number, int divider) {
        if(Integer.parseInt(number) % divider != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_REMAINDER.getMessage());
        }
    }

    public static void validateDelimiterFormat(String numbers, String delimiter, int count) {
        if(numbers.split(delimiter).length != count) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    public static void validateDuplicateNumber(List<String> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateExistNumber(List<Integer> numbers, int number) {
        if(numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_NUMBER.getMessage());
        }
    }

    public static void validateNumberInRange(String number, int start, int end) {
        if(Integer.parseInt(number) < start || Integer.parseInt(number) > end) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
        }
    }
}
