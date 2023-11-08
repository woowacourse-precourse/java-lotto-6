package lotto;

import java.util.List;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> compareNumbers(List<Integer> nums) {
        List<Integer> matchList = getNumbers().stream().filter(o -> {
            return nums.contains(o);
        }).toList();
        return matchList;
    }

    public boolean compareBonusNumber(int bonusNum) {
        return numbers.contains(bonusNum);
    }
}