package lotto.domain;

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

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNum(int checkNum) {
        return numbers.contains(checkNum);
    }

    @Override
    public String toString() {
        String numbersArray = "[";

        for(int number : numbers) {
            numbersArray = numbersArray + number + ", ";
        }

        numbersArray = numbersArray.substring(0, numbersArray.length() - 2);
        numbersArray = numbersArray + "]";

        return numbersArray;
    }
}
