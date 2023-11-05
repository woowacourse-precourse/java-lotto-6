package lotto.validator;


import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

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
