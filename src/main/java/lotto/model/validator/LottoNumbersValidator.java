package lotto.model.validator;

import java.util.List;
import java.util.Set;
import lotto.common.config.LottoGameRule;
import lotto.common.exception.ErrorMessage;
import lotto.model.Lotto;

public class LottoNumbersValidator extends InputValidator {

    public static void validateLottoNumberRange(int lottoNumber) {
        if (!isLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.message());
        }
    }

    private static boolean isLottoNumberRange(int lottoNumber) {
        return LottoGameRule.MIN_LOTTO_NUMBER.getConstant() <= lottoNumber
                && LottoGameRule.MAX_LOTTO_NUMBER.getConstant() >= lottoNumber;
    }

    public static void validateLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoGameRule.LOTTO_NUMBERS_SIZE.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.message());
        }
    }

    public static void validateDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> NonDuplicatedLottoNumbers = Set.copyOf(lottoNumbers);
        if (lottoNumbers.size() != NonDuplicatedLottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBERS.message());
        }
    }

    public static void validateContainLottoNumbers(int bonusNumber, Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_LOTTO_NUMBERS.message());
        }
    }
}
