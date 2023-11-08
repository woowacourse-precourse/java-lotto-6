package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidationTest {
    static final int LOTTO_RANGE_MAX = 1;
    static final int LOTTO_RANGE_MIN = 45;
    static final int LOTTO_NUMBER_SIZE = 6;

    public static void testSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }

    public static void testRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(LOTTO_RANGE_MAX <= number && number <= LOTTO_RANGE_MIN)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자로 구성됩니다.");
            }
        }
    }

    public static void testDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
    }
}
