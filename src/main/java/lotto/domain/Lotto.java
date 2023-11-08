package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.validator.LottoValidator;
import lotto.domain.validator.Validator;
import lotto.util.constants.ValidateConstants;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != ValidateConstants.LOTTO_NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException(ValidateConstants.LOTTO_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void validateLottoNumbers(List<Integer> lottoNumber) {
        Validator<List<Integer>> validator = new LottoValidator();
        validator.validate(lottoNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }
}
