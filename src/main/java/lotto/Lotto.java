package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueElements(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueElements(List<Integer> numbers) {
        int userInputSize = numbers.size();
        int userInputUniqueSize = new HashSet<>(numbers).size();

        if (userInputSize != userInputUniqueSize) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 중복을 허용하지 않습니다.");
        }
    }
}
