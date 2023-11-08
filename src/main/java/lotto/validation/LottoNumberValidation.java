package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidation {
    public void validateDuplicateLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        Set<Integer> numbers = new HashSet<>(lottoNumbers);

        if (lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_CONSTRAINT_MESSAGE.getMessage());
        }
    }
}
