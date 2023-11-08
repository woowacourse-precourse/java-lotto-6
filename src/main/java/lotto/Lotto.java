package lotto;

import java.util.List;

enum Reward {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private Integer amount;

    private Reward(Integer amount) {
        this.amount = amount;
    }

    private static Reward[] rewards = Reward.values();

    public static Integer getReward(Integer score) {
        if (score < 6) {
            return rewards[score].amount;
        }
        return 0;
    }
}

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

    public void printLotto() {
        System.out.println(numbers);
    }

    public Integer matchingLotto(List<Integer> luckNumbers, Integer bonusNumber) {
        Integer score = 7;
        for (Integer number : numbers) {
            if (luckNumbers.contains(number)) {
                score = score - 1;
            }
        }
        if (numbers.contains(bonusNumber) && score == 2) {
            score = 1;
        }
        if (score == 1) {
            score = 0;
        }
        return Reward.getReward(score);
    }
}
