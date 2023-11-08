package lotto;

import java.util.List;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        try {
            LottoValidationTest.testSize(numbers);
        } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        try {
            LottoValidationTest.testRange(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 1이상 45이하의 숫자로 구성됩니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        try {
            LottoValidationTest.testDuplication(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
