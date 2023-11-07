package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer correctLottoCnt = 0;
    private boolean isBonus = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void updateCorrectLottoCnt() {
        correctLottoCnt += 1;
    }

    public void updateBonus() {
        isBonus = true;
    }

    public Integer getCorrectLottoCnt() {
        return correctLottoCnt;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
