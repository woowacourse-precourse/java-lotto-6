package lotto.domain;

import java.util.List;
import lotto.constant.Rewards;

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

    public Rewards checkReward(WinningNumber winningNumber, Integer bonus) {
        Integer count = countSameNumber(winningNumber);
        boolean hasBonus = hasBonus(bonus);
        return Rewards.of(count, hasBonus);
    }

    private Integer countSameNumber(WinningNumber winningNumber) {
        int count = 0;
        for (Integer number : winningNumber.getNumbers()) {
            if (numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean hasBonus(Integer bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
