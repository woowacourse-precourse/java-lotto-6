package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복될 수 없습니다.");
        }
    }

    public void printNumbers() {
        try {
            Collections.sort(this.numbers);
            System.out.println(this.numbers);
        } catch (UnsupportedOperationException e) {
            System.out.println(this.numbers);
        }
    }

    public int countMatchingNumbers(Lotto winningLotto, int bonus) {
        int count = 0;
        for (int num : this.numbers) {
            if (winningLotto.numbers.contains(num)) {
                count++;
            }
        }
        boolean isBonus = bonusMatch(count, bonus);

        return Statistic.getRank(count, isBonus);
    }

    public boolean bonusMatch(int count, int bonus) {
        boolean isBonus = false;
        if (count == 5 && this.numbers.contains(bonus)) {
            isBonus = true;
        }
        return isBonus;
    }
}
