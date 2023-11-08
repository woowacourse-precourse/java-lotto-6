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

    private Reward[] rewards = Reward.values();

    public Integer getReward(Integer ranking) {
        ranking = ranking - 1;
        return rewards[ranking].amount;
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

    // TODO: 추가 기능 구현
}
