package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final String CHECK_LOTTO_SIZE_REQUEST_MESSAGE = "로또 번호는 총 6개 여야 합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(CHECK_LOTTO_SIZE_REQUEST_MESSAGE);
        }
    }

    public int countOverlappingNumbers(Lotto other) {
        Set<Integer> removedOverlappingNumbers = new HashSet<>();
        removedOverlappingNumbers.addAll(numbers);
        removedOverlappingNumbers.addAll(other.getNumbers());

        return LOTTO_SIZE * 2 - removedOverlappingNumbers.size();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}