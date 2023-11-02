package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    private static final int SECOND_RANK = 9;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateNumberDuplication(numbers);
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        Set numbersToSet = new HashSet(numbers);
        for (int i : numbers) {
            numbersToSet.add(i);
        }
        if (numbers.size() != numbersToSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoNumbers() {
        Set arrangeNumbers = new TreeSet(numbers);
        String lottoNumbers = arrangeNumbers.toString();
        return lottoNumbers;
    }

    public int checkResult(List<Integer> winningNumbers, int bonusNumber) {
        int matchedNumberCount = 0;
        Set arrangeNumbers = new TreeSet(numbers);
        for (int i = 0; i < 6; i++) {
            if(arrangeNumbers.contains(winningNumbers.get(i))) {
                matchedNumberCount++;
                arrangeNumbers.remove(winningNumbers.get(i));
            }
        }
        if (matchedNumberCount == 5) {
            if (arrangeNumbers.contains(bonusNumber)) {
                matchedNumberCount = SECOND_RANK;
            }
        }
        return matchedNumberCount;
    }
}
