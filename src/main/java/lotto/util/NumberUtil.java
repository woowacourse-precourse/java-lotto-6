package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberUtil {

    private NumberUtil() {}

    public static final List<Integer> numberGenerator(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }

    public static final void validateNumberRange(int min, int max, List<Integer> numbers) {
        if (numbers.stream()
                .filter(number -> number >= min && number <= max)
                .count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
