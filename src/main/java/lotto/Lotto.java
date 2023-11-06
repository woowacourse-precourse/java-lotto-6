package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbersInRange(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void checkNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    private void checkNumberInRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("당첨(보너스) 번호는 1 ~ 45 사이의 값을 가집니다.");
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkOneDuplicatedNumber(number, numbers);
        }
    }

    private void checkOneDuplicatedNumber(int number, List<Integer> numbers) {
        for (Integer oneNumber : numbers) {
            if (number == oneNumber) {
                throw new IllegalArgumentException("당첨(보너스) 번호는 서로 중복되는 숫자가 없습니다. 다시 입력해주세요.");
            }
        }
    }
}
