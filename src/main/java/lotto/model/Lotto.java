package lotto.model;

import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리여야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복될 수 없습니다.");
        }
    }

    public int countMatches(Lotto lotto) {
        Long count = lotto.numbers.stream()
                .filter(number -> this.numbers.contains(number))
                .count();

        return count.intValue();
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.existIn(numbers);
    }

    public LottoDto toDto() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return new LottoDto(Collections.unmodifiableList(sortedNumbers));
    }
}
