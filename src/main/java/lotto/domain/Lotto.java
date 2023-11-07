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

        if (count == 6) {
            return Rewards.FIRST;
        }
        if (count == 5) {
            if (hasBonus) {
                return Rewards.SECOND;
            }
            return Rewards.THIRD;
        }
        if (count == 4) {
            return Rewards.FOURTH;
        }
        if (count == 3) {
            return Rewards.FIFTH;
        }
        return Rewards.LOSE;
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
