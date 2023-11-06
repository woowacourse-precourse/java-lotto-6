package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        Validation.validateDuplicationList(lottoNumbers);
        Validation.validateSize(lottoNumbers, LOTTO_NUMBERS_SIZE);
        Validation.validateNumberListInRange(lottoNumbers, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }
}
