package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.Number;

public class Validator {

    public static void inputBlank(String inputPurchase) {
        if (inputPurchase.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INPUT_BLANK.getMessage());
        }
    }

    public static void parseIntNumber(String inputPurchase) {
        inputBlank(inputPurchase);
        for (int numberOfDigits = 0; numberOfDigits < inputPurchase.length(); numberOfDigits++) {
            if (!Character.isDigit(inputPurchase.charAt(numberOfDigits))) {
                throw new IllegalArgumentException(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
            }
        }
    }

    public static void notZeroOfRestDividedThousand(int integerPurchase) {
        if (integerPurchase % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_NOT_UNDIVIDED_NUMBER_OF_THOUSAND.getMessage());
        }

    }

    public static void validateInputLength(List<Integer> inputNumbers) {
        if (inputNumbers.size() != Number.LOTTO_LENGTH_LIMIT.getMessage()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_NOT_SIX_LENGTH.getMessage());
        }
    }

    public static void duplicateInputWinningNumbers(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (inputNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void duplicateBonusNumber(int inputBonusNumbers, List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        uniqueNumbers.add(inputBonusNumbers);
        if (inputNumbers.size() + 1 != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static void outOfLottoNumericalRange(int lottoNumber) {
        if (lottoNumber < Number.THE_SMALLEST_LOTTO_NUMBER.getMessage() ||
                lottoNumber > Number.THE_BIGGEST_LOTTO_NUMBER.getMessage()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_OUT_OF_LANGE.getMessage());
        }
    }

}
