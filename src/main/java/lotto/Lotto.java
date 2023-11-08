package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 6개의 숫자만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public static Lotto buy() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    //TODO: 기능 구현
    public static int matches(Lotto lotto) {
        return 0;
    }
}
