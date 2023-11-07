package lotto;

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
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


    public Prize calculatePrize(List<Integer> winningNumbers, int bonusNumber) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        if (matchingCount == 6) {
            return Prize.FIRST;
        }
        if (matchingCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return Prize.SECOND;
            }
            return Prize.THIRD;
        }
        if (matchingCount == 4) {
            return Prize.FOURTH;
        }
        if (matchingCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.NO_PRIZE;
    }

}
