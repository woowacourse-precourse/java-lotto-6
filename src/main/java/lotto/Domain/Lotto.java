package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

/*- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
        - `numbers`의 접근 제어자인 private을 변경할 수 없다.
        - `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
 */

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsNumberInRange(numbers);
        validateIsNumberDuplicate(numbers);
        validateEachLottoNumber(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호를 입력했습니다.";
    private static final String LOTTO_NUMBER_IS_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";

    public static void validateIsNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

        public static void validateIsNumberDuplicate(List < Integer > numbers) {
            Set<Integer> existingNumbers = new HashSet<>();

            for (Integer number : numbers) {
                if (existingNumbers.contains(number)) {
                    throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
                }
                existingNumbers.add(number);
            }
        }

        public static void validateEachLottoNumber (List < Integer > numbers) {
            for (Integer number : numbers) {
                try {
                    Integer.parseInt(number.toString());
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_NUMERIC_ERROR_MESSAGE);
                }
            }
        }


}