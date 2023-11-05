package lotto.domain;

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

    public boolean containLottoNumber(int num) {
        return numbers.contains(num);
    }

    public int matchCount(WinningLotto winningLotto) {
        int matchCount = 0;
        for (int winningNumber : winningLotto.getWinningLottoNumbers()) {
            if (containLottoNumber(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
