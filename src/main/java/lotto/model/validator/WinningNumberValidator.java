package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.BLANK_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.INVALID_NUMBER_OF_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;

public class WinningNumberValidator {
    public static void checkNumberOfLottoNumbers(List<String> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkBlankOfLottoNumbers(List<String> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(BLANK_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkInRangeOfLottoNumbers(List<Integer> lottoNumbers) {
        checkMinimum(lottoNumbers);
        checkMaximum(lottoNumbers);
    }

    private static void checkMinimum(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch((num) -> num < MINIMUM_OF_LOTTO_NUMBER.getDetails())) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkMaximum(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch((num) -> num > MAXIMUM_OF_LOTTO_NUMBER.getDetails())) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkDuplicateLottoNumbers(List<Integer> lottoNumbers) {
        HashSet<Integer> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
