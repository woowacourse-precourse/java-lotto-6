package lotto.model.validator;

import java.util.List;
import java.util.Set;
import lotto.common.config.LottoGameRule;
import lotto.common.exception.ErrorMessage;

public class LottoNumbersValidator extends InputValidator {

    public static void validateLottoNumberRange(Integer lottoNumber) {
        if (LottoGameRule.MIN_LOTTO_NUMBER.constant() > lottoNumber
                || LottoGameRule.MAX_LOTTO_NUMBER.constant() < lottoNumber) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.message());
        }
    }

    public static void validateLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoGameRule.LOTTO_NUMBERS_SIZE.constant()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.message());
        }
    }

    public static void validateDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> NonDuplicatedLottoNumbers = Set.copyOf(lottoNumbers);
        if (lottoNumbers.size() != NonDuplicatedLottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.message());
        }
    }
}
