package lotto.model;

import lotto.exception.LottoException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_COUNT = 6;
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new LottoException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (distinctNumbers.size() != NUMBER_COUNT) {
            throw new LottoException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int countMatchedNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean isBonusMatch(int bonusBall) {
        return numbers.contains(bonusBall);
    }
}
