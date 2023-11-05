package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 없이 입력해주세요.");
        }

        for (int number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자를 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNum(int checkNum) {
        return numbers.contains(checkNum);
    }

    @Override
    public String toString() {
        String numbersArray = "[";

        for (int number : numbers) {
            numbersArray = numbersArray + number + ", ";
        }

        numbersArray = numbersArray.substring(0, numbersArray.length() - 2);
        numbersArray = numbersArray + "]";

        return numbersArray;
    }
}
