package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (incorrectLottoSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개여야 합니다.");
        }
        if (isOverlapLottoNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또번호가 있습니다.");
        }
    }

    private boolean incorrectLottoSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean isOverlapLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }

    public boolean containLottoNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }

    public int matchCount(WinningLotto winningLotto) {
        return (int) winningLotto.getWinningLottoNumbers().stream()
                .filter(this::containLottoNumber)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
