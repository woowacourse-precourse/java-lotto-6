package lotto;

import java.util.Collections;
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
        validateDuplicateNumbers(numbers);
        validateRangeOfNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException("[ERROR] 중복 숫자가 존재합니다.");
                }
            }
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }


    public void displayLottoNumbers() {
        List<Integer> numbers = this.numbers;

        System.out.println(numbers);
    }


}
