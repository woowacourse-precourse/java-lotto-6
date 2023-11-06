package lotto;

import java.util.List;
import java.util.Objects;

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
            throw new IllegalArgumentException("로또 번호는 6개의 숫자입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    /*
     * Lotto의 숫자들이 1 ~ 45 사이의 숫자인지 확인
     */
    private void checkNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    private void checkNumberInRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 값을 가집니다.");
        }
    }

    /*
     * Lotto의 숫자들 중 중복되는 숫자가 있는지 확인
     */
    private void checkDuplicatedNumber(List<Integer> numbers) {
        for (int idx = 0; idx < numbers.size(); idx++) {
            checkOneDuplicatedNumber(idx, numbers);
        }
    }

    private void checkOneDuplicatedNumber(int idx, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (idx != i && Objects.equals(numbers.get(idx), numbers.get(i))) {
                throw new IllegalArgumentException("로또 번호는 서로 중복되는 숫자가 없습니다. 다시 입력해주세요.");
            }
        }
    }
}
