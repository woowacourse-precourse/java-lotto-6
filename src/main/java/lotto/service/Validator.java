package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.Number;

public class Validator {

    public static void ParseIntNumber(String inputPurchase) {
        for (int numberOfDigits = 0; numberOfDigits < inputPurchase.length(); numberOfDigits++) {
            if (!Character.isDigit(inputPurchase.charAt(numberOfDigits))) {
                throw new IllegalArgumentException(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
            }
        }
    }

    public static void notZeroOfRestDividedThousand(int integerPurchase) {
        if (integerPurchase % Number.THOUSAND.getMessage() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_NOT_UNDIVIDED_NUMBER_OF_THOUSAND.getMessage());
        }

    }

    public static void validateInputLength(List<Integer> inputNumbers) {
        if (inputNumbers.size() != Number.LOTTO_LENGTH_LIMIT.getMessage()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_MORE_THAN_SIX.getMessage());
        }
    }

    public static void duplicateInputLottoNumbers(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (inputNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void duplicateBonusNumber(int inputBonusNumbers, List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        uniqueNumbers.add(inputBonusNumbers);
        if (inputNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static void validateInputNumbers(List<Integer> inputNumbers) {

    }

    public static void outOfLottoNumericalRange(List<Integer> inputNumbers) {

    }

    public static void outOfBonusNumericalRange(int inputBonusNumbers) {

    }

}
