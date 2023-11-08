package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또는 6자리 숫자로 입력해야합니다.");
        }
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("로또번호는 1~45사이의 숫자로 입력해야 합니다.");
            }
        }
        Set<Integer> check = new HashSet<>(numbers);
        if (check.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
            }
        }
    // TODO: 추가 기능 구현
}
