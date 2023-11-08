package lotto.utils;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoEnum;

import java.util.List;

public class Validator {

    public static void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getError());
        }
    }

    public static void isContainBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK_ERROR.getError());
        }
    }

    public static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_ERROR.getError());
        }
    }

    public static void notNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getError());
        }
    }

    public static void underByLottoPrice(String input) {
        int num = Integer.parseInt(input);
        if (num < LottoEnum.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_LOTTO_PRICE_ERROR.getError());
        }
    }

    public static void isDivisibleByLottoSize(String input) {
        int num = Integer.parseInt(input);
        if (num % LottoEnum.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_1000_ERROR.getError());
        }
    }

    public static void isDuplicate(List<Integer> numbers, int input, int idx) {
        for (int i = idx + 1; i < numbers.size(); i++) {
            if (input == numbers.get(i)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getError());
            }
        }
    }

    public static void isDuplicate(List<String> numbers, String input, int idx) {
        for (int i = idx + 1; i < numbers.size(); i++) {
            if (input.equals(numbers.get(i))) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getError());
            }
        }
    }

    public static void isOneToFortyFive(int input) {
        if (input < LottoEnum.LOTTO_MIN_NUMBER.getValue() || input > LottoEnum.LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_TO_FORTYFIVE_ERROR.getError());
        }
    }
}
