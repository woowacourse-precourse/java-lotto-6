package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidation {
    ErrorMessage error;
    public void validateDuplicateLottoNumbers(Lotto lotto) {
        Set<Integer> numbers = new HashSet<>();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        for (Integer number : lottoNumbers) {
            numbers.add(number);
        }

        if (lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(error.DUPLICATE_LOTTO_NUMBER_CONSTRAINT_MESSAGE.getMessage());
        }
    }
}
