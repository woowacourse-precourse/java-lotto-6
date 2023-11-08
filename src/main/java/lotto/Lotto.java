package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int maxLottoNum = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
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

    private void duplicateCheck(List<Integer> numbers) {
        Integer[] tmp = new Integer[maxLottoNum + 1];
        for (int i = 0; i < maxLottoNum + 1; i++) {
            tmp[i] = 0;
        }
        for (Integer n : numbers) {
            if (tmp[n] == 1) {
                throw new IllegalArgumentException();
            }
            tmp[n] = 1;
        }
    }
}
