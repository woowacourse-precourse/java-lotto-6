package lotto.model;

import static lotto.exception.Validator.validateLottoDuplicate;
import static lotto.exception.Validator.validateLottoNumberOverMax;
import static lotto.exception.Validator.validateLottoSizeCheck;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSizeCheck(numbers);
        validateLottoDuplicate(numbers);
        validateLottoNumberOverMax(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int matchLottoCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(number -> (int) lottoNumbers.stream()
                        .filter(lotto -> lotto == number)
                        .count())
                .sum();
    }

    public boolean isBonusMatch(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
