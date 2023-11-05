package lotto.Domain;

import java.util.List;

public class PlayerNumber {
    private List<Integer> numbers;

    public PlayerNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
