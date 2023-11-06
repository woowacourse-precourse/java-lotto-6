package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> generateRandomLotto(int number) {
        // TODO: 미구현
        return null;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        // TODO: numbers 내부 중복 값 검증 필요
    }

    public LottoMatchResult matchWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        return null;
    }
}
