package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        outOfRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getWinnerNumbers() {
        return numbers;
    }

    public int matchingNumbers(Lotto winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::containNumber).count();
    }

    public boolean containNumber(int num) {
        return numbers.contains(num);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자가 6개가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void duplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }
        }
    }

    private void outOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
            }
        }
    }
}
