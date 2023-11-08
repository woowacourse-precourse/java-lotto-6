package lotto.validator;

import lotto.common.LottoCount;
import lotto.error.LottoErrorMessage;
import lotto.exception.LottoNumberException;
import java.util.List;

public class ValidatorLottoNumbers {
    public static void validateStringNumberList(List<String> lottoNumbers) {
        lottoNumbers.forEach(number -> isNumericValue(number));
        isDuplicated(lottoNumbers);
    }

    public static void validateNumberList(List<Integer> lottoNumbers) {
        isInvalidSize(lottoNumbers);
        isDuplicated(lottoNumbers);
    }

    private static void isInvalidSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoCount.LOTTO_COUNT_NUMBER) {
            throw LottoNumberException.of(LottoErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private static void isDuplicated(List<?> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw LottoNumberException.of(LottoErrorMessage.DUPLICATED_LOTTO_NUMBERS);
        }
    }

    private static void isNumericValue(String buyingPrice) {
        try {
            Integer.parseInt(buyingPrice);
        } catch (NumberFormatException e) {
            throw LottoNumberException.of(LottoErrorMessage.WRONG_LOTTO_NUMBER);
        }
    }
}
