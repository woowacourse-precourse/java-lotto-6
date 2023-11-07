package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        final int NUMBER_COUNT = LottoSetting.NUMBER_COUNT.getValue();
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + NUMBER_COUNT + "개의 숫자여야 합니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        final int INCLUSIVE_START = LottoSetting.NUMBER_RANGE_START.getValue();
        final int INCLUSIVE_END = LottoSetting.NUMBER_RANGE_END.getValue();

        for (int number : numbers) {
            if (number < INCLUSIVE_START || INCLUSIVE_END < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                        + INCLUSIVE_START + "부터 "
                        + INCLUSIVE_END + " 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        final int OFFSET = LottoSetting.NUMBER_RANGE_START.getValue();
        final int NUMBER_RANGE_COUNT = LottoSetting.NUMBER_RANGE_END.getValue()
                                        - LottoSetting.NUMBER_RANGE_START.getValue() + 1;
        boolean[] checked = new boolean[NUMBER_RANGE_COUNT];
        Arrays.fill(checked, false);

        for (int number : numbers) {
            if (hasNumber(checked, number, OFFSET)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 수를 가질 수 없습니다.");
            }
        }
    }

    private boolean hasNumber(boolean[] checked, int number, int offset) {
        if (checked[number - offset]) {
            return true;
        }
        checked[number - offset] = true;
        return false;
    }

    public boolean hasNumber(int number) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    // TODO: 추가 기능 구현
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
