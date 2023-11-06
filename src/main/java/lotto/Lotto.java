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

    public String lottoFormat() {
        StringBuilder result = new StringBuilder();

        for (Integer number : numbers) {
            if (!result.isEmpty()) {
                result.append(", ");
            }
            result.append(number);
        }

        return "[" + result.toString() + "]";
    }

    public Integer compareWithWinNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        int label = 0;

        for (Integer n : numbers) {
            if (winNumbers.contains(n)) {
                label++;
            }
        }
        if (label == 5) {
            if (numbers.contains(bonusNumber)) {
                label = 7;
            }
        }

        return label;
    }


}
