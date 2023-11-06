package lotto.util;

import static lotto.util.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String MONEY_NEGATIVE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000 단위로 받습니다.";

    public static List<Integer> validateLottoNumber(String input) { // 1,2,3,4,5,6
        List<String> strings = splitByComma(input);
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String str : strings) {
            lottoNumbers.add(Integer.parseInt(str));
        }
        return lottoNumbers;
    }

    public static int validateBonusNumber(String input) {
        return parseInt(input);
    }

    public static int validateMoneyIsValid(String input) {
        int number = parseInt(input);
        validateMoneyIsPositive(number);
        validateMoneyDivideBy1000(number);
        return number/1000;
    }

    public static void validateMoneyIsPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void validateMoneyDivideBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_FORMAT_ERROR_MESSAGE);
        }
    }
}