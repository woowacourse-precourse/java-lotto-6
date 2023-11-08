package lotto.model;

import static lotto.util.validators.LottoValidator.validateLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public LottoDTO toDTO() {
        return new LottoDTO(numbers);
    }

    public Integer countMatchingNumbers(WinningNumbers winNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winNumbers::contains)
                .count());
    }

    public boolean hasMatchedBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }
}
