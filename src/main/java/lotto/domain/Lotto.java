package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 숫자의 갯수를 확인하세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복 숫자가 존재합니다";

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
