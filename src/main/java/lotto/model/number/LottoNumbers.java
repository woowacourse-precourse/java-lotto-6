package lotto.model.number;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public record LottoNumbers(List<LottoNumber> numbers) {
    public LottoNumbers {
        Validator.validateLottoNumbers(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public List<LottoNumber> getSortedNumbers() {
        return new ArrayList<>(numbers.stream().sorted().toList());
    }
}
