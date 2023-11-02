package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int SECOND_RANK = 9;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }

    public int checkResult(List<Integer> winningNumbers, int bonusNumber) {
        int matchedNumberCount = 0;
        for (int i = 0; i < 6; i++) {
            if(numbers.contains(winningNumbers.get(i))) {
                matchedNumberCount++;
                numbers.remove(winningNumbers.get(i));
            }
        }
        if (matchedNumberCount == 5) {
            if (numbers.contains(bonusNumber)) {
                matchedNumberCount = SECOND_RANK;
            }
        }
        return matchedNumberCount;
    }
}
