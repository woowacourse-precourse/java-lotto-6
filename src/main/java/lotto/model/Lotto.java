package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_AMOUNT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다.");
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복입니다.");
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer Num : numbers) {
            if (Num < LOTTO_START_NUMBER || Num > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위 오류입니다.");
            }
        }
    }
}
