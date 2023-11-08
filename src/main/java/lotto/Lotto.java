package lotto;

import java.util.List;
import java.util.ArrayList;

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

    // TODO: 추가 기능 구현
    public int lottery(List<Integer> winNums) {
        final int NUM_OF_LOTTO_NUMBERS = 6;

        List<Integer> compNumbers = new ArrayList<Integer>();
        compNumbers.addAll(numbers);
        compNumbers.removeAll(winNums);

        return NUM_OF_LOTTO_NUMBERS - compNumbers.size();
    }

    public int lottery(int bonusNum) {
        final int NUM_OF_LOTTO_NUMBERS = 6;

        List<Integer> compNumbers = new ArrayList<Integer>();
        compNumbers.addAll(numbers);
        compNumbers.remove(bonusNum);

        return NUM_OF_LOTTO_NUMBERS - compNumbers.size();
    }
}
