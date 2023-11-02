package lotto.validation;

import java.util.List;

public class Validation {
    public void validateUnit(int payment) {
        if(payment % 1000 != 0) {
            throw new IllegalArgumentException("입력값이 1,000원 단위가 아닙니다.");
        }
    }

    public void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("입력된 숫자가 6개가 아닙니다.");
        }
    }
}