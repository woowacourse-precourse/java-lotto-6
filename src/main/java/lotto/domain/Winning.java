package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.StringUtils;

public class Winning {

    private static final int NUMBER_OF_LOTTO = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> numbers;

    public Winning(String input) {
        numbers = validate(input);
    }

    private List<Integer> validate(String input) {
        List<Integer> numbers = StringUtils.stringToNumbers(input);
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 필요합니다.");
        }

        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }

            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자입니다.");
            }
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
