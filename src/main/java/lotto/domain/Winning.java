package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.StringUtils;

public class Winning {

    private List<Integer> numbers;

    public Winning(String input) {
        numbers = validate(input);
    }

    private List<Integer> validate(String input) {
        List<Integer> numbers = StringUtils.stringToNumbers(input);
        if (numbers.size() != 6) { // TODO: 6 상수처리
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 필요합니다.");
        }

        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }

            if (number < 1 || 45 < number) { // TODO: 1, 45 상수처리
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자입니다.");
            }
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
