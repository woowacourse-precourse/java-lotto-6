package lotto;

import java.util.List;
import java.util.stream.Collectors;

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
        int size = numbers.size();
        int size1 = numbers.stream().collect(Collectors.toSet()).size();

        if (size != size1) {
            throw new IllegalArgumentException("[ERROR] 로또 입력 값은 중복을 허용하지 않습니다.");
        }
    }
}
