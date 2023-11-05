package lotto.validator;


import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void validateNumberIsLottoNumber(int number, String exceptionMessage) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateDuplicateLottoNumber(List<Integer> lottoNumbers) {
        Set<Integer> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != uniqueLottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }
}
