package lotto.domain;

import lotto.validation.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        Validation.validateDuplicationList(lottoNumbers);
        Validation.validateSize(lottoNumbers, LOTTO_NUMBERS_SIZE);
    }
}
