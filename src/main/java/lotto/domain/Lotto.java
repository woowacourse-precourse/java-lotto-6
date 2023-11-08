package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.exception.LottoExceptionList.NUMBERS_DUPLICATE_ERROR;
import static lotto.domain.exception.LottoExceptionList.NUMBERS_LENGTH_ERROR;

public class Lotto {
    private final List<Integer> numbers;
    private int hits = 0;
    private boolean bonusStatus;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getHits() {
        return hits;
    }

    public boolean getBonusStatus() {
        return bonusStatus;
    }

    public void updateHits() {
        hits++;
    }

    public void changeBonusStatus() {
        bonusStatus = true;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_LENGTH_ERROR.getMessage());
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> numbersDuplicateCheck = new HashSet<>(numbers);
        if (numbersDuplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }
}
