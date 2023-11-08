package lotto;

import java.util.List;
import java.util.Collections;

public class Lotto {
    static final int LOTTO_RANGE_MAX = 1;
    static final int LOTTO_RANGE_MIN = 45;
    static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        while (true) {
            if (!validateSize(numbers)) {
                continue;
            }
            if (!validateRange(numbers)) {
                continue;
            }
            if (!validateDuplication(numbers)) {
                continue;
            }
            break;
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private boolean validateSize(List<Integer> numbers) {
        try {
            LottoValidationTest.testSize(numbers);
        } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 로또 번호는 6개의 숫자입니다.");
            return false;
        }
        return true;
    }

    private boolean validateRange(List<Integer> numbers) {
        try {
            LottoValidationTest.testRange(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 1이상 45이하의 숫자로 구성됩니다.");
            return false;
        }
        return true;
    }

    private boolean validateDuplication(List<Integer> numbers) {
        try {
            LottoValidationTest.testDuplication(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
