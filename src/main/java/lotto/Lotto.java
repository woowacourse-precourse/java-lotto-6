package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 있으면 안됩니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private int countWinningNumber(Lotto winningLotto) {
        int count = 0;
        for (int n : winningLotto.getNumbers()) {
            if (this.numbers.contains(n)) {
                count++;
            }
        }
        return count;
    }

    public Rank judgeRank(Lotto winningLotto, int bonusNumber) {
        int count = countWinningNumber(winningLotto);
        if (count == 5 && this.numbers.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == count) {
                return rank;
            }
        }
        return Rank.MISS;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
