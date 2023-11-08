package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.exception.InvalidLottoNumberException;

public final class LottoNumberValidator {

    private LottoNumberValidator() {

    }

    public static void validateLottoNumber(Integer lottoNumber) {
        if (isOutOfRange(lottoNumber)) {
            throw new InvalidLottoNumberException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (isInvalidLottoNumbersCount(lottoNumbers.size())) {
            throw new InvalidLottoNumberException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID);
        }
        if (isLottoNumbersContainsDuplicatedNumber(lottoNumbers)) {
            throw new InvalidLottoNumberException(
                ErrorMessage.LOTTO_NUMBER_CONTAINS_DUPLICATED_NUMBER);
        }
        for (Integer number : lottoNumbers) {
            LottoNumberValidator.validateLottoNumber(number);
        }
    }

    private static Boolean isOutOfRange(Integer lottoNumber) {
        return lottoNumber < LottoConstant.LOTTO_NUMBER_MIN.getValue()
            || lottoNumber > LottoConstant.LOTTO_NUMBER_MAX.getValue();
    }

    private static Boolean isInvalidLottoNumbersCount(Integer lottoNumberCount) {
        return lottoNumberCount != LottoConstant.LOTTO_NUMBER_COUNT.getValue();
    }

    private static Boolean isLottoNumbersContainsDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        return numberSet.size() != lottoNumbers.size();
    }
}
