package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        countNumbers(numbers);
    }

    private void countNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String[] stringLotto() {
        String[] lottoNumbers = new String[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            lottoNumbers[i] = String.valueOf(numbers.get(i));
        }
        return lottoNumbers;
    }
}
