package lotto.util.validation;

import lotto.util.ErrorThrower;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.ErrorMessage.LOTTO_DISTINCT_ERROR;
import static lotto.config.ErrorMessage.ONLY_NUMBER_ERROR;

public class LottoValidation {

    public void validatorOnlyNumber(String input) {

        if (!input.matches("[0-9]+")) {
            ErrorThrower.throwIllegalArgumentException(ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorDuplicatedNumber(List<Integer> lottoNumbers) {

        lottoNumbers = lottoNumbers.stream().distinct().collect(Collectors.toList());

        if (lottoNumbers.size() != 6) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_DISTINCT_ERROR.getMessage());
        }

    }

}
