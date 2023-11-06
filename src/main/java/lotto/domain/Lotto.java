package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isInRangeLottoNumbers(numbers);
        isCorrectSizeLottoNumbers(numbers);
        isNoDuplicateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getWins(Lotto winningLotto) {
        int winCount = 0;

        for (int i = 0; i < 6; i++) {
            if (winningLotto.numbers.contains(this.numbers.get(i))) {
                winCount++;
            }
        }
        return winCount;
    }

    public void isInRangeLottoNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > 45 || num < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void isCorrectSizeLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void isNoDuplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복된 숫자가 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }
}
