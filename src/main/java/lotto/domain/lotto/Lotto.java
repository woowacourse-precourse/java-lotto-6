package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean containBonusNum(int num) {
        return numbers.contains(num);
    }

    public boolean contains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countSameNum(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }
}
