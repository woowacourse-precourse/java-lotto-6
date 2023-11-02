package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
}
