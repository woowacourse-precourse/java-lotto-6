package model;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개를 넘어갑니다.");
        }
        Set<Integer> uniqueWinningNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueWinningNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 사용하면 안됩니다.");
            }
        }
    }

    public String toString() {
        return numbers.toString();
    }

    public int getLottoMatchingCount(List<Integer> lottoWinningNumbers) {
        int count = 0;

        for (Integer number : numbers) {
            if (lottoWinningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean getLottoMatchBonus(int lottoBonusNumber) {
        boolean result = false;
        for (Integer number : numbers) {
            if (number == lottoBonusNumber) {
                result = true;
            }
        }
        return result;
    }
}
