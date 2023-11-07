package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkValidation(numbers);
        this.numbers = makeSorted(numbers);
    }

    private List<Integer> makeSorted(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        Collections.sort(sorted);
        return sorted;
    }

    private void checkValidation(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
        }
        for (Integer number : numbers) {
            new LottoNumber(number);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        return numbersWithoutDuplication.size() != numbers.size();
    }

    public boolean hasIt(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Ranking getRanking(Lotto winningNumber, int bonusNumber) {
        int count = 0;
        boolean hasBonusNumber = hasIt(bonusNumber);

        for (Integer number : numbers) {
            if (winningNumber.hasIt(number)) {
                count++;
            }
        }
        return Ranking.valudOf(count, hasBonusNumber);
    }
}
