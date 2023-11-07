package lotto.utils;

import lotto.constants.LottoEnum;

import java.util.List;

public class Validator {

    public static boolean isNull(String input) {
        return input == null;
    }

    public static boolean isContainBlank(String input) {
        return input.contains(" ");
    }

    public static boolean isBlank(String input) {
        return input.equals(" ");
    }

    public static boolean isNumber(String input) {
        return input.matches("\\d+");
    }

    public static boolean underByLottoPrice(String input) {
        int num = Integer.parseInt(input);
        return num < LottoEnum.LOTTO_PRICE.getValue();
    }

    public static boolean isDivisibleByLottoSize(String input) {
        int num = Integer.parseInt(input);
        return num % LottoEnum.LOTTO_PRICE.getValue() == 0;
    }

    public static boolean isDuplicate(List<Integer> numbers, int input, int idx) {
        for (int i = idx + 1; i < numbers.size(); i++) {
            if (input == numbers.get(i)) return true;
        }
        return false;
    }

    public static boolean isOneToFortyFive(int input) {
        return input >= LottoEnum.LOTTO_MIN_NUMBER.getValue() && input <= LottoEnum.LOTTO_MAX_NUMBER.getValue();
    }
}
