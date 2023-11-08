package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String INVALID_MIN_VALUE = "[ERROR] 번호 생성 시 최소값(1) 보다 작은 값이 있습니다.";
    public static final String INVALID_MAX_VALUE = "[ERROR] 번호 생성 시 최대값(45) 보다 큰 값이 있습니다.";
    public static final String INVALID_SIZE = "[ERROR] 번호가 6개로 생성되지 않았습니다.";
    public static final String DUPLICATE_VALUES = "[ERROR] 번호 중 중복된 값이 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        vaildRandomNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    public void vaildRandomNumbers(List<Integer> winnerNumbers) {
        vaildRandomNumberRange(winnerNumbers);
        vaildRandomNumberSize(winnerNumbers);
        vaildRandomNumberDuplication(winnerNumbers);
    }

    void vaildRandomNumberRange(List<Integer> winnerNumbers) {
        for (int winnerNumber : winnerNumbers) {
            if (winnerNumber < 1) {
                throw new IllegalArgumentException(INVALID_MIN_VALUE);
            }
            if (winnerNumber > 45) {
                throw new IllegalArgumentException(INVALID_MAX_VALUE);
            }
        }
    }

    void vaildRandomNumberSize(List<Integer> randomNumbers) {
        if (randomNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    void vaildRandomNumberDuplication(List<Integer> randomNumbers) {
        Set<Integer> uniqueNumber = new HashSet<>(randomNumbers);
        if (uniqueNumber.size() != randomNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_VALUES);
        }
    }
}
