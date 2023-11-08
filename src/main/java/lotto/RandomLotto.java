package lotto;

import java.util.List;

public class RandomLotto {
    private final List<Integer> randomNumbers;

    public RandomLotto(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

}
