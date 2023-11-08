package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String INVALID_LOTTO_LENGTH_MESSAGE = "[ERROR] 로또 번호의 개수는 6개를 입력해야 합니다.";


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size())
            throw new IllegalArgumentException();
    }
}
