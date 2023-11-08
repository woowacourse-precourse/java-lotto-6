package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countContainsLottoNumber(WinningNumbers winningNumbers) {
        return (int) this.numbers.stream()
                .filter(number -> winningNumbers.containsLottoNumber(number))
                .count();
    }

    public LottoResult getResult(WinningNumbers winningNumbers) {
        int count = countContainsLottoNumber(winningNumbers);
        boolean bonusNumberContains = winningNumbers.matchBonusNumbers(this.numbers);
        if (count == 5 && bonusNumberContains) {
            return LottoResult.SECOND;
        }
        return LottoResult.of(count);
    }
}
